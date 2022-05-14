package interfaces;

import models.News;

import java.util.List;

public interface NewsDao {

    //Create
    void add(News news);

    //Read

    List<News> getAllNews();
    News findById(int id);

    //Delete
    void deleteById(int id);
    void clearAllNews();
}
