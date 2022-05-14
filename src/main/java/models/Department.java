package models;

import java.util.Objects;

public class Department {

    private String departmentName;
    private String description;
    private int departmentSize;
    private int id;

    public Department(String departmentName, String description, int departmentSize) {
        this.departmentName = departmentName;
        this.description = description;
        this.departmentSize = departmentSize;
    }
//getters
    public String getDepartmentName() {
        return departmentName;
    }
    public String getDescription() {
        return description;
    }
    public int getDepartmentSize() {
        return departmentSize;
    }
    public int getId() {
        return id;
    }
//setters
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDepartmentSize(int departmentSize) {
        this.departmentSize = departmentSize;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return departmentSize == that.departmentSize && id == that.id && departmentName.equals(that.departmentName) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, description, departmentSize, id);
    }
}
