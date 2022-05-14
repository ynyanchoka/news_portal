package dao;


import models.Department;
import dao.Sql2oDepartmentDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static org.junit.jupiter.api.Assertions.*;

class Sql2oDepartmentDaoTest {
    private static Connection conn;
    static String connectionString = "jdbc:postgresql://localhost:5432/newsportal_test";
    static Sql2o sql2o = new Sql2o(connectionString, null, null);

    private static Sql2oDepartmentDao departmentDao =  new Sql2oDepartmentDao(sql2o);
   


    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/newsportal_test";
        Sql2o sql2o = new Sql2o(connectionString, null, null);
        departmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        departmentDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void addingDepartmentSetsId() throws Exception {
        Department testDepartment = setupNewDepartment();
        int originalDepartmentId = testDepartment.getId();
        departmentDao.add(testDepartment);
        assertNotEquals(originalDepartmentId,testDepartment.getId());
    }

    @Test
    public void getsAllDepartments() throws Exception{
        Department testDepartment = setupNewDepartment();
        Department otherDepartment=new Department("HR","recruiting",10);
        departmentDao.add(testDepartment);
        departmentDao.add(otherDepartment);
        assertEquals(2, departmentDao.getAll().size());
    }
    @Test
    public void deleteByIdDeletesCorrectDepartment() throws Exception {
        Department testDepartment = setupNewDepartment();
        departmentDao.add(testDepartment);
        departmentDao.deleteById(testDepartment.getId());
        assertEquals(0, departmentDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Department testDepartment = setupNewDepartment();
        Department otherDepartment=new Department("HR","recruiting",10);
        departmentDao.clearAll();
        assertEquals(0, departmentDao.getAll().size());
    }




     public Department setupNewDepartment (){
            return new Department("IT", "Installation and maintenance of computer network system", 12);
}       }