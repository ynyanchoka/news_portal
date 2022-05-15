package dao;

import interfaces.NewsDao;
import models.Department;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {

    private final Sql2o sql2o;
    public Sql2oNewsDao (Sql2o sql2o){ this.sql2o = sql2o; }


    @Override
    public void add(News news) {
        String sql = "INSERT INTO news (title,description,departmentname,type,createdat) VALUES (:title,:description ,:departmentName,:type,:createdat)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            news.setId(id);
        } catch (
                Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<News> getAllNews() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }

    @Override
    public News findById(int id) {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM news where id=:id";
            News news = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(News.class);
            return news;
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from news WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void clearAllNews() {
        String sql = "DELETE from news";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
