package gt.cs4420.relationaldb.domain.query;

public enum ValueOperator implements Operator {

    EQUALS("="),
    NOT_EQUALS("!="),
    LESS_THAN("<"),
    LESS_THAN_EQUAL_TO("<="),
    GREATER_THAN(">"),
    GREATER_THAN_EQUAL_TO(">=");

    private final String stringRepresentation;

    private ValueOperator(final String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String getStringRepresentation() {
        return stringRepresentation;
    }

    public static ValueOperator getByStringRepresentation(final String stringRepresentation) {
        for (ValueOperator operator : ValueOperator.values()) {
            if (operator.getStringRepresentation().equalsIgnoreCase(stringRepresentation)) {
                return operator;
            }
        }

        return null;
    }


}
