package dao;

import interfaces.DepartmentNewsDao;
import models.DepartmentNews;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentNewsDao implements DepartmentNewsDao {
    private final Sql2o sql2o;
    public Sql2oDepartmentNewsDao (Sql2o sql2o){ this.sql2o = sql2o; }



    @Override
    public void add(DepartmentNews departmentNews) {
        String sql = "INSERT INTO news (title,description,departmentname,type,departmentid) VALUES (:title,:description ,:departmentName,:type,:departmentId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(departmentNews)
                    .executeUpdate()
                    .getKey();
            departmentNews.setId(id);
        } catch (
                Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public List<DepartmentNews> getAllDepartmentNews() {
        try(Connection connection = sql2o.open()) {
            return connection.createQuery("SELECT * FROM news")
                    .executeAndFetch(DepartmentNews.class);
        }
    }

    @Override
    public News findById(int id) {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM news where id=:id";
            DepartmentNews departmentNews = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(DepartmentNews.class);
            return departmentNews;
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
    public void clearAllDepartmentNews() {
        String sql = "DELETE from news";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }


}
