package interfaces;

import models.Department;
import models.User;

import java.util.List;

public interface UserDao {

    //Create
    void add(User user);
    void addUserToDepartment(User user, Department department);

    //Read
    User findById(int id);
    List<User> getAllUsers();
    public List<Department> getAllUserDepartments(int user_id);

    //Delete
    void deleteById(int id);
    void clearAllUsers();
}
