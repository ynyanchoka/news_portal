package models;

import java.util.Objects;

public class User {
    private int id;
    private  String name;
    private String position;
    private String role;
    private String department;
    private  int departmentId;

    public User(String name, String position, String role, String department,int departmentId) {
        this.name = name;
        this.position = position;
        this.role = role;
        this.department = department;
        this.departmentId = departmentId;
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
    public int getDepartmentId() {
        return departmentId;
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
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && departmentId == user.departmentId && Objects.equals(name, user.name) && Objects.equals(position, user.position) && Objects.equals(role, user.role) && Objects.equals(department, user.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position, role, department, departmentId);
    }



}
