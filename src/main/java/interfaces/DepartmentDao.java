package interfaces;

import models.Department;
import models.News;
import models.User;

import java.util.List;

public interface DepartmentDao {
    //CREATE
    void add(Department department);



    //READ
    List<Department> getAll();
    Department findById(int id);
    List<User> getAllUsersInDepartment(int department_id);



    //DELETE
    void clearAll();
    public void deleteById(int id);
}
