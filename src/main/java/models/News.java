package models;

import java.util.Objects;

public class News {
    public String title;
    public String description;
    public String departmentName;
    public int id;
    public String type;
//    public static final String TYPE = "General news";

    public News(String title, String description, String type) {
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public News(String title, String description, String departmentName, String type) {
        this.title = title;
        this.description = description;
        this.departmentName = departmentName;
        this.type = type;
    }
//GETTERS
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getDepartmentName() {
        return departmentName;
    }

    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
//SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return id == news.id && title.equals(news.title) && description.equals(news.description) && departmentName.equals(news.departmentName) && type.equals(news.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, departmentName, id, type);
    }
}
