package dao;

import models.Department;
import models.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oUserDaoTest {

    private static Connection conn;
    static String connectionString = "jdbc:postgresql://localhost:5432/newsportal_test";
    static Sql2o sql2o = new Sql2o(connectionString, null, null);

    private static Sql2oUserDao userDao =  new Sql2oUserDao(sql2o);



    @BeforeClass
    public static void setUp() throws Exception {
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        userDao.clearAllUsers();
    }
    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void addingUserSetsId() throws Exception {
        User testUser = setupUser();
        int originalUserId = testUser.getId();
        userDao.add(testUser);
        assertNotEquals(originalUserId,testUser.getId());
    }
    @Test
    public void getsAllUsers() throws Exception{
        User testUser = setupUser();
        User otherUser= new User("MD","UX","NBV","NBV", 2);
        userDao.add(testUser);
        userDao.add(otherUser);
        assertEquals(2, userDao.getAllUsers().size());
    }
    @Test
    public void noUserReturnsEmptyList() throws Exception {
        assertEquals(0, userDao.getAllUsers().size());
    }


    @Test
    public void clearAll() throws Exception {
        User testUser = setupUser();
        User otherUser= new User("MD","UX","NBV","NBV", 2);
        userDao.clearAllUsers();
        assertEquals(0, userDao.getAllUsers().size());
    }


    //HELPER
    public User setupUser (){
        return new User ("Ymelda", "Junior designer", "UX designer", "UX",1);
    }

}