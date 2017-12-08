package net.repetitor.model;

/**
 * @author Volodymyr Burtsev at 06.12.2017 15:42
 */
public class Region {

    private int id;
    private String name;
    private int counryId;

    public Region(String name, int counryId) {
        this.name = name;
        this.counryId = counryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounryId() {
        return counryId;
    }

    public void setCounryId(int counryId) {
        this.counryId = counryId;
    }

}