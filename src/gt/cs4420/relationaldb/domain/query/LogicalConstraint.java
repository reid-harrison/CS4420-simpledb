package gt.cs4420.relationaldb.domain.query;

public class LogicalConstraint implements Constraint {

    private LogicalOperator operator;

    private Constraint leftConstraint;
    private Constraint rightConstraint;

    public LogicalConstraint(final LogicalOperator operator, final Constraint leftConstraint, final Constraint rightConstraint) {
        this.operator = operator;
        this.leftConstraint = leftConstraint;
        this.rightConstraint = rightConstraint;
    }

    public LogicalOperator getOperator() {
        return operator;
    }

    public Constraint getLeftConstraint() {
        return leftConstraint;
    }

    public void setLeftConstraint(final Constraint leftConstraint) {
        this.leftConstraint = leftConstraint;
    }

    public Constraint getRightConstraint() {
        return  rightConstraint;
    }

    public void setRightConstraint(final Constraint rightConstraint) {
        this.rightConstraint = rightConstraint;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof LogicalConstraint)) {
            return false;
        }

        LogicalConstraint otherConstraint = (LogicalConstraint) other;

        if (!this.operator.equals(otherConstraint.getOperator())) {
            return false;
        }

        if (!this.leftConstraint.equals(otherConstraint.getLeftConstraint())) {
            return false;
        }

        if (!this.rightConstraint.equals(otherConstraint.getRightConstraint())) {
            return false;
        }

        return true;
    }

}
