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
    public Sql2oDepartmentDao (Sql2o sql2o){ this.sql2o = sql2o; }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO department (departmentname,description,departmentsize) VALUES (:departmentName,:description,:departmentSize)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
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
        String joinQuery= "SELECT user_id FROM departments_staff WHERE department_id=:department_id";
        try (Connection con=sql2o.open()){
            List<Integer> allUserIds=con.createQuery(joinQuery)
                    .addParameter("department_id",department_id)
                    .executeAndFetch(Integer.class);

            for(Integer user_id : allUserIds) {
                String userQuery = "SELECT * FROM users WHERE id=:id";
                user.add(con.createQuery(userQuery)
                        .addParameter("user_id", user_id)
                        .executeAndFetchFirst(User.class));
            }

        } catch (Sql2oException ex){
                System.out.println(ex);
        }
            return user;
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
