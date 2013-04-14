package gt.cs4420.relationaldb.domain.query;

import gt.cs4420.relationaldb.domain.Attribute;

public class ValueConstraint implements Constraint {

    private Operator operator;
    private Attribute attribute;
    private Object value;

    public ValueConstraint(final Attribute attribute, final Object value, final Operator operator) {
        this.attribute = attribute;
        this.value = value;
        this.operator = operator;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public enum Operator {

        EQUALS("="),
        NOT_EQUALS("!="),
        LESS_THAN("<"),
        GREATER_THAN(">");

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
