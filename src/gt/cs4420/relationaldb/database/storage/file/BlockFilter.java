package gt.cs4420.relationaldb.database.storage.file;

import com.google.common.collect.Lists;
import gt.cs4420.relationaldb.database.storage.block.Block;
import gt.cs4420.relationaldb.domain.Row;
import gt.cs4420.relationaldb.domain.query.Constraint;

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
        //TODO Implement constraint checking
        return false;
    }

}
