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
    public void getDepartmentReturnsCorrectDepartment() throws Exception {
        DepartmentNews testDepartmentNews = setupDepartmentNews();
        assertEquals("UX", testDepartmentNews.getDepartmentName());
    }

    @Test
    public void setDepartmentSetsCorrectDepartment() throws Exception {
        DepartmentNews testDepartmentNews = setupDepartmentNews();
        testDepartmentNews.setDepartmentName("NBV");
        assertNotEquals("UX",testDepartmentNews.getDepartmentName());
    }

    //HELPER
    public DepartmentNews setupDepartmentNews (){
        return new DepartmentNews ("Training", "Training scheduled tomorrow", "Department news" ,3);
    }
}