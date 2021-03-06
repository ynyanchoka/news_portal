package dao;

import interfaces.UserDao;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao {
    private final Sql2o sql2o;
    public Sql2oUserDao (Sql2o sql2o){ this.sql2o = sql2o; }
    public void add(User user) {
        String sql = "INSERT INTO users (name,position,role,department,departmentid) VALUES (:name,:position ,:role,:department,:departmentId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(user)
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public User findById(int id) {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM users where id=:id";
            User user = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
            return user;
        }
    }

    @Override
    public List<User> getAllUserInDepartments(int departmentId) {
        try (Connection con=sql2o.open()) {
            String sql = "SELECT  * FROM users WHERE departmentid=:departmentId";
            return con.createQuery(sql)
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public User deleteById(int id) {
        String sql = "DELETE from users WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

        return null;
    }

    @Override
    public void clearAllUsers() {
        String sql = "DELETE from users";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
