package models;

public class User {
    private int id;
    private  String name;
    private String position;
    private String role;
    private String department;

    public User(String name, String position, String role, String department) {
        this.name = name;
        this.position = position;
        this.role = role;
        this.department = department;
    }
//GETTERS
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public String getRole() {
        return role;
    }
    public String getDepartment() {
        return department;
    }
    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
