package gt.cs4420.relationaldb.domain;

public enum DataType {

    INT("INT"),

    STRING("STRING");

    private String typeString;

    private DataType(final String typeString) {
        this.typeString = typeString;
    }

    public String getTypeString() {
        return typeString;
    }

}
