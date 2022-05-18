package interfaces;

import models.Department;
import models.User;

import java.util.List;

public interface UserDao {

    //Create
    void add(User user);

    //Read
    User findById(int id);


    public List<User> getAllUserInDepartments(int departmentId);

    List<User> getAllUsers();


    //Delete
    void deleteById(int id);
    void clearAllUsers();
}
