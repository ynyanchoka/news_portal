package dao;

import interfaces.UserDao;
import models.Department;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oUserDao implements UserDao {
    private final Sql2o sql2o;
    public Sql2oUserDao (Sql2o sql2o){ this.sql2o = sql2o; }
    public void add(User user) {
        String sql = "INSERT INTO users (name,position,role,department,departmentId) VALUES (:name,:position ,:role,:department,:departmentId)";
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
    public List<Department> getAllUserInDepartments(int user_id) {
        List<Department> department=new ArrayList<>();
        try (Connection con=sql2o.open()) {
            String sql = "SELECT department_id FROM departments_staff WHERE user_id=:user_id";
            List<Integer> departmentId = con.createQuery(sql)
                    .addParameter("user_id", user_id)
                    .executeAndFetch(Integer.class);

            for (Integer id : departmentId) {
                String userResults = "SELECT * FROM department WHERE id=:id";
                department.add(con.createQuery(userResults)
                        .addParameter("id", id)
                        .executeAndFetchFirst(Department.class));

            }

            return department;
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
    public void deleteById(int id) {
        String sql = "DELETE from users WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

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
