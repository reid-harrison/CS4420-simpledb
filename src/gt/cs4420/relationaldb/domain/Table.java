package gt.cs4420.relationaldb.domain;

public class Table {

    private Integer id;
    private String name;

    private Attribute[] attributes;

    public Table() {
        this(-1);
    }

    public Table(final Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(final Attribute[] attributes) {
        this.attributes = attributes;
    }
}
