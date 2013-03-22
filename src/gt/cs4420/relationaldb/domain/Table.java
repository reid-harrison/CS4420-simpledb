package gt.cs4420.relationaldb.domain;


public class Table {

    private Integer id;
    private String name;
    private Description desc;

    public Table() {
        this(null);
    }

    public Table(final Integer id) {
        setId(id);
    }

    public Table(final Integer id, final String name, final Description desc) {
        this(id);
        setName(name);
        setDescription(desc);
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

    public Description getDescription() {
        return desc;
    }

    public void setDescription(final Description desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Table)) {
            return false;
        }

        return this.id.equals(((Table) other).getId());
    }

}
