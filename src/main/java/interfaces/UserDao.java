package interfaces;

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
    User deleteById(int id);
    void clearAllUsers();
}
