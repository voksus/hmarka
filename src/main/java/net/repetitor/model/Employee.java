package net.repetitor.model;

/**
 * @author Volodymyr Burtsev at 06.12.2017 15:37
 */
public class Employee {

    private int id;
    private String login;
    private String name;

    public Employee(String login, String name) {
        this.login = login;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}