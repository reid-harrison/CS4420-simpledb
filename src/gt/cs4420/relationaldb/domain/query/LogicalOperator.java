package gt.cs4420.relationaldb.domain.query;

public enum LogicalOperator implements Operator {

    AND("AND"),
    OR("OR");

    private final String stringRepresentation;

    private LogicalOperator(final String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String getStringRepresentation() {
        return stringRepresentation;
    }

    public static LogicalOperator getByStringRepresentation(final String stringRepresentation) {
        for (LogicalOperator operator : LogicalOperator.values()) {
            if (operator.getStringRepresentation().equalsIgnoreCase(stringRepresentation)) {
                return operator;
            }
        }

        return null;
    }

}
