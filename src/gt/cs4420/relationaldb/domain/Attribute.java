package gt.cs4420.relationaldb.domain;

/**
 * TODO:
 * I don't think I've used attributeId anywhere. Maybe it isn't needed.
 */
public class Attribute {

    private DataType type;
    private String name;
    private Integer attributeId;

    public Attribute() {
        type = null;
        name = null;
        attributeId = null;
    }

    public Attribute(final String name) {
        setName(name);
    }

    public Attribute(final DataType type, final String name) {
        this(name);
        setType(type);
    }

    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Attribute)) {
            return false;
        }

        String otherName = ((Attribute) other).getName();

        if (name == null) {
            if (otherName == null) {
                return true;
            }

            return false;
        }

        return name.equalsIgnoreCase(otherName);
    }
}
