package dao;

import interfaces.DepartmentDao;
import models.Department;
import models.News;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;
    public Sql2oDepartmentDao (Sql2o sql2o){ this.sql2o = sql2o; } //making the sql2o object available everywhere so we can call methods in it

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO department (departmentname,description,departmentsize) VALUES (:departmentName,:description,:departmentSize)";
        try(Connection con = sql2o.open()){ //try to open a connection
            int id = (int) con.createQuery(sql, true) //make a new variable
                    .bind(department) //map argument onto the query, so we can use information from it
                    .executeUpdate()//run it all
                    .getKey();//int id is now the row number (row “key”) of db
            department.setId(id);//update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex);// error!
        }
    }


    @Override
    public void addUserToDepartment(User user, Department department) {

    }

    @Override
    public List<Department>getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM department")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department findById(int id) {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM department where id=:id";
            Department department = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
            return department;
        }
    }

    @Override
    public List<User> getAllUsersInDepartment(int department_id) {
        List<User> user=new ArrayList<>();
        try (Connection con=sql2o.open()){
            String sql= "SELECT user_id FROM departments_staff WHERE department_id=:department_id";
            List<Integer> userIds=con.createQuery(sql)
                    .addParameter("department_id",department_id)
                    .executeAndFetch(Integer.class);

            for(Integer id : userIds){
                String userResults="SELECT * FROM users WHERE id=:id";
                user.add(con.createQuery(userResults)
                        .addParameter("id",id)
                        .executeAndFetchFirst(User.class));

            }

            return user;
        }
    }

    @Override
    public List<News> getDepartmentNews(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from department WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from department";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }
}
