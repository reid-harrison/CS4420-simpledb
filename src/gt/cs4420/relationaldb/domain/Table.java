package gt.cs4420.relationaldb.domain;


import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class Table {

    private Integer id;
    private String name;
    private Description desc;

    private Map<Integer, Map<Attribute, Object>> data;

    public Table() {
        this(-1);
    }

    public Table(final Integer id) {
        this.id = id;

        data = Maps.newHashMap();
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

    public void addRow(final Map<Attribute, Object> attributes) {
        Integer index = generateIndex();

        data.put(index, attributes);
    }

    /**
     * Dummy method for index generation, needs to be implemented
     */
    private Integer generateIndex() {
        //TODO Implement proper indexing
        return null;
    }

}
