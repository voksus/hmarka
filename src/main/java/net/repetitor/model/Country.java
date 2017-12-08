package net.repetitor.model;

/**
 * @author Volodymyr Burtsev at 06.12.2017 15:38
 */
public class Country {

    private int id;
    private String name;

    public Country(String name) {
        this.name = name;
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

}