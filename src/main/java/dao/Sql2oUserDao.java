package dao;

import interfaces.UserDao;
import models.Department;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao {
    private final Sql2o sql2o;
    public Sql2oUserDao (Sql2o sql2o){ this.sql2o = sql2o; }
    public void add(User user) {
        String sql = "INSERT INTO users (name,position,role,department) VALUES (:name,:position ,:role,:department)";
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
    public void addUserToDepartment(User user, Department department) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void clearAllUsers() {

    }
}