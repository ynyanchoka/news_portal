package interfaces;

import models.Department;
import models.User;

import java.util.List;

public interface UserDao {

    //Create
    void add(User user);

    //Read
    User findById(int id);

    List<Department> getAllUserInDepartments(int user_id);

    List<User> getAllUsers();


    //Delete
    void deleteById(int id);
    void clearAllUsers();
}
