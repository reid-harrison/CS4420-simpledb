package gt.cs4420.relationaldb.domain.query;

import gt.cs4420.relationaldb.domain.Attribute;

public class JoinConstraint implements Constraint {

    private JoinType type;

    private ValueOperator operator;
    private Attribute leftAttribute;
    private Attribute rightAttribute;

    public JoinConstraint(final JoinType type, final ValueOperator operator, final Attribute leftAttribute, final Attribute rightAttribute) {
        this.type = type;
        this.operator = operator;
        this.leftAttribute = leftAttribute;
        this.rightAttribute = rightAttribute;
    }

    public JoinType getJoinType() {
        return type;
    }

    @Override
    public ValueOperator getOperator() {
        return operator;
    }

    public Attribute getLeftAttribute() {
        return leftAttribute;
    }

    public Attribute getRightAttribute() {
        return rightAttribute;
    }

    public enum JoinType {

        INNER;

    }
}
