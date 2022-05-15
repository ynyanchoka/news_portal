package models;

import java.util.Objects;

public class DepartmentNews extends News{
    public static final String TYPE = "Department news";
    private  int departmentId;

    public DepartmentNews(String title, String description, String type,int departmentId) {
        super(title, description, type);
        this.departmentId = departmentId;
    }

//GETTERS

    public int getDepartmentId() {
        return departmentId;
    }


//SETTERS
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }


}
