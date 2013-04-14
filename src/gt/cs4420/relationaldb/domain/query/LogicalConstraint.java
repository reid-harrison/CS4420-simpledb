package gt.cs4420.relationaldb.domain.query;

import gt.cs4420.relationaldb.domain.Attribute;

public class LogicalConstraint implements Constraint {

    private Operator operator;

    private Constraint leftConstraint;
    private Constraint rightConstraint;

    public LogicalConstraint(final Operator operator, final Constraint leftConstraint, final Constraint rightConstraint) {
        this.operator = operator;
        this.leftConstraint = leftConstraint;
        this.rightConstraint = rightConstraint;
    }

    public Operator getOperator() {
        return operator;
    }

    public Constraint getLeftConstraint() {
        return leftConstraint;
    }

    public Constraint getRightConstraint() {
        return  rightConstraint;
    }


    public enum Operator {

        AND("AND"),
        OR("OR");

        private final String stringRepresentation;

        private Operator(final String stringRepresentation) {
            this.stringRepresentation = stringRepresentation;
        }

        public String getStringRepresentation() {
            return stringRepresentation;
        }

        public static Operator getByStringRepresentation(final String stringRepresentation) {
            for (Operator operator : Operator.values()) {
                if (operator.getStringRepresentation().equalsIgnoreCase(stringRepresentation)) {
                    return operator;
                }
            }

            return null;
        }

    }
}
