package gt.cs4420.relationaldb.domain.query;

import gt.cs4420.relationaldb.domain.Attribute;

public class ValueConstraint implements Constraint {

    private ValueOperator operator;
    private Attribute attribute;
    private Object value;

    public ValueConstraint(final Attribute attribute, final Object value, final ValueOperator operator) {
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

    public ValueOperator getOperator() {
        return operator;
    }

    public void setOperator(ValueOperator operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof ValueConstraint)) {
            return false;
        }

        ValueConstraint otherConstraint = (ValueConstraint) other;

        if (!this.operator.equals(otherConstraint.getOperator())) {
            return false;
        }

        if (!this.attribute.equals(otherConstraint.getAttribute())) {
            return false;
        }

        if (!this.value.equals(otherConstraint.getValue())) {
            return false;
        }

        return true;
    }

}
