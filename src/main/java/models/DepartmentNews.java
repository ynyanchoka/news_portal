package models;

import java.util.Objects;

public class DepartmentNews extends News{
    public static final String TYPE = "Department news";
    public String departmentName;

    public DepartmentNews(String title, String description, String type,String departmentName) {
        super(title, description, type);
        this.departmentName = departmentName;
    }

    @Override
    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


}
