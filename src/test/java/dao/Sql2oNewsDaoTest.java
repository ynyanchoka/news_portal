package dao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oNewsDaoTest {

    private static Connection conn;
    static String connectionString = "jdbc:postgresql://localhost:5432/newsportal_test";
    static Sql2o sql2o = new Sql2o(connectionString, null, null);

    private static Sql2oNewsDao newsDao =  new Sql2oNewsDao (sql2o);



    @BeforeClass
    public static void setUp() throws Exception {
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        newsDao.clearAllNews();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

}