package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Lists;
import gt.cs4420.relationaldb.database.storage.block.Block;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Row;
import gt.cs4420.relationaldb.domain.query.*;

import java.util.List;

public class BlockFilter {

    private Constraint constraint;

    public BlockFilter(final Constraint constraint) {
        this.constraint = constraint;
    }

    public List<Row> filterRows(final Block block) {
        List<Row> filteredRows = Lists.newArrayList();

        for (Row row : block.getBlockData()) {
            if (rowMeetsConstraints(row)) {
                filteredRows.add(row);
            }
        }

        return filteredRows;
    }

    private boolean rowMeetsConstraints(final Row row) {
        return rowMeetsConstraint(row, this.constraint);
    }

    private boolean rowMeetsConstraint(final Row row, final Constraint constraint) {
        if (constraint instanceof LogicalConstraint) {
            LogicalConstraint lc = (LogicalConstraint) constraint;

            return rowMeetsConstraint(row, lc.getLeftConstraint()) && rowMeetsConstraint(row, lc.getRightConstraint());
        }

        if (constraint instanceof ValueConstraint) {
            ValueConstraint vc = (ValueConstraint) constraint;
            return  rowMeetsValueConstraint(row, vc);
        }

        throw new IllegalStateException("Filter constraint could not be casted to an appropriate type, this shouldn't happen.");
    }

    private boolean rowMeetsValueConstraint(final Row row, final ValueConstraint constraint) {
        Attribute constraintAttr = constraint.getAttribute();
        ValueOperator operator = constraint.getOperator();
        Object constraintVal = constraint.getValue();
        Object rowVal = row.getRowData().get(constraintAttr);
        String constraintValString = constraintVal.toString();

        // If the value starts and ends with ' then it is a string
        if (constraintValString.startsWith("'") && constraintValString.endsWith("'")) {
            String rowValString = rowVal.toString();
            constraintValString = constraintValString.substring(1, constraintValString.length() - 1);

            switch (constraint.getOperator()) {
                case EQUALS:
                    return rowValString.equals(constraintValString);
                case NOT_EQUALS:
                    return !rowValString.equals(constraintValString);
                case GREATER_THAN:
                    return rowValString.compareTo(constraintValString) > 0;
                case GREATER_THAN_EQUAL_TO:
                    return rowValString.compareTo(constraintValString) >= 0;
                case LESS_THAN:
                    return rowValString.compareTo(constraintValString) < 0;
                case LESS_THAN_EQUAL_TO:
                    return rowValString.compareTo(constraintValString) <= 0;
            }
        }

        //Probably an integer, let's make sure
        int constraintValInt;
        int rowValInt;

        try {
            constraintValInt = Integer.parseInt(constraintVal.toString());
            rowValInt = (Integer) rowVal;
        } catch (final NumberFormatException nfe) {
            //Hmm, wasn't an integer
            throw nfe;
        } catch (final ClassCastException cce) {
            //Well damn, this doesn't work;
            throw cce;
        }

        switch (constraint.getOperator()) {
            case EQUALS:
                return rowValInt == constraintValInt;
            case NOT_EQUALS:
                return rowValInt != constraintValInt;
            case GREATER_THAN:
                return rowValInt > constraintValInt;
            case GREATER_THAN_EQUAL_TO:
                return rowValInt >= constraintValInt;
            case LESS_THAN:
                return rowValInt < constraintValInt;
            case LESS_THAN_EQUAL_TO:
                return rowValInt <= constraintValInt;
        }

        return false;
    }

}
