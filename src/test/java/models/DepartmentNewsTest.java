package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentNewsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void instantiatesDepartmentNewsObjectsCorrectly_true() throws Exception {
        DepartmentNews testDepartmentNews = setupDepartmentNews();
        assertEquals(true, testDepartmentNews instanceof DepartmentNews);
    }
    @Test
    public void getDepartmentIDReturnsCorrectDepartment() throws Exception {
        DepartmentNews testDepartmentNews = setupDepartmentNews();
        assertEquals(5, testDepartmentNews.getDepartmentId());
    }

    @Test
    public void setDepartmentIDSetsCorrectDepartment() throws Exception {
        DepartmentNews testDepartmentNews = setupDepartmentNews();
        testDepartmentNews.setDepartmentId(7);
        assertNotEquals(5,testDepartmentNews.getDepartmentId());
    }

    //HELPER
    public DepartmentNews setupDepartmentNews (){
        return new DepartmentNews ("Training", "Training scheduled tomorrow", "Department news" ,5);
    }
}