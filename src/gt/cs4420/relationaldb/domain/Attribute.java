package gt.cs4420.relationaldb.domain;

public class Attribute {

    private DataType type;
    private String name;
    private Integer attributeId;

    public Attribute(final DataType type, final String name) {
        this.type = type;
        this.name = name;
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

        return name.equals(otherName);
    }
}
