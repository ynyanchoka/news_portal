package dao;

import interfaces.NewsDao;
import models.Department;
import models.News;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    public void addingDepartmentSetsId() throws Exception {
        News testNews = setupNews();
        int originalNewsId = testNews.getId();
        newsDao.add(testNews);
        assertNotEquals(originalNewsId,testNews.getId());
    }

    @Test
    public void getsAllNews() throws Exception{
        News testNews = setupNews();
        News otherNews=new News("Training", "Training scheduled tomorrow", "General news");
        newsDao.add(testNews);
        newsDao.add(otherNews);
        assertEquals(2, newsDao.getAllNews().size());
    }

    @Test
    public void noNewsReturnsEmpty() throws Exception {
        assertEquals(0, newsDao.getAllNews().size());
    }
    @Test
    public void deleteByIdDeletesCorrectNews() throws Exception {
        News testNews = setupNews();
        newsDao.add(testNews);
        newsDao.deleteById(testNews.getId());
        assertEquals(0, newsDao.getAllNews().size());
    }

    @Test
    public void clearAll() throws Exception {
        News testNews = setupNews();
        News otherNews=new News("Training", "Training scheduled tomorrow", "General news");
        newsDao.clearAllNews();
        assertEquals(0, newsDao.getAllNews().size());
    }

    //HELPER
    public News setupNews (){
        return new News ("Training", "Training scheduled tomorrow",  "Department news");
    }
    public News setupAltNews (){
        return new News ( "Training", "Training scheduled tomorrow", "Department news" );
    }

}