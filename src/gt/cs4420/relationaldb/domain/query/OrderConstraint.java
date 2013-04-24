package gt.cs4420.relationaldb.domain.query;

import gt.cs4420.relationaldb.domain.Attribute;

public class OrderConstraint {

    private Attribute attribute;
    private Direction direction;

    public OrderConstraint(final Attribute attribute, final Direction direction) {
        this.attribute = attribute;
        this.direction = direction;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public Direction getDirection() {
        return direction;
    }

    public enum Direction {

        ASCENDING("ASC"),
        DESCENDING("DESC");

        private final String stringRepresentation;

        private Direction(final String stringRepresentation) {
            this.stringRepresentation = stringRepresentation;
        }

        public String getStringRepresentation() {
            return stringRepresentation;
        }

        public static Direction getByStringRepresenations(final String stringRepresentation) {
            for (Direction dir : Direction.values()) {
                if (dir.getStringRepresentation().equalsIgnoreCase(stringRepresentation)) {
                    return dir;
                }
            }

            return null;
        }
    }
}
