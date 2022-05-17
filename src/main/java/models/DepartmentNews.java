package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DepartmentNews extends News{

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
