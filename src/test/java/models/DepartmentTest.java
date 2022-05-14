package models;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void instantiatesDepartmentObjectsCorrectly_true() throws Exception {
        Department testDepartment = setupDepartment();
        assertEquals(true, testDepartment instanceof Department);
    }
    @Test
    public void getDepartmentNameReturnsCorrectName() throws Exception {
        Department testDepartment = setupDepartment();
        assertEquals("IT", testDepartment.getDepartmentName());
    }
    @Test
    public void getDescriptionReturnsCorrectDescription() throws Exception {
        Department testDepartment = setupDepartment();
        assertEquals("Installation and maintenance of computer network system", testDepartment.getDescription());
    }
    @Test
    public void getSizeReturnsCorrectSize() throws Exception {
        Department testDepartment = setupDepartment();
        assertEquals(12, testDepartment.getDepartmentSize());
    }

    @Test
    public void setNameSetsCorrectName() throws Exception {
        Department testDepartment = setupDepartment();
        testDepartment.setDepartmentName("HR");
        assertNotEquals("IT",testDepartment.getDepartmentName());
    }
    @Test
    public void setDescriptionSetsCorrectDescription() throws Exception {
        Department testDepartment = setupDepartment();
        testDepartment.setDescription("Recruitment");
        assertNotEquals("Installation and maintenance of computer network system",testDepartment.getDescription());
    }
    @Test
    public void setSizeSetsCorrectSize() throws Exception {
        Department testDepartment = setupDepartment();
        testDepartment.setDepartmentSize(Integer.parseInt(String.valueOf(9)));
        assertNotEquals(12,testDepartment.getDepartmentSize());
    }


    //helpers
    public Department setupDepartment (){
        return new Department("IT", "Installation and maintenance of computer network system", 12);
    }
}