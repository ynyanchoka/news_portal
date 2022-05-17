package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class News {

    public String title;
    public String description;
    public int id;
    public String type;
    private long createdat;
    private String formattedCreatedAt;



    public News(String title, String description, String type) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.createdat = System.currentTimeMillis();
        setFormattedCreatedAt();
    }




    //GETTERS
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public long getCreatedat() {
        return createdat;
    }






//SETTERS
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreatedat() {
        this.createdat = System.currentTimeMillis();
    }


    public String getFormattedCreatedAt(){
        Date date = new Date(createdat);
        String datePatternToUse = "MM/dd/yyyy @ K:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
        return sdf.format(date);
    }

    public void setFormattedCreatedAt(){
        Date date = new Date(this.createdat);
        String datePatternToUse = "MM/dd/yyyy @ K:mm a";
        SimpleDateFormat sdf = new SimpleDateFormat(datePatternToUse);
        this.formattedCreatedAt = sdf.format(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return id == news.id && title.equals(news.title) && description.equals(news.description)  && type.equals(news.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, id, type);
    }
}
