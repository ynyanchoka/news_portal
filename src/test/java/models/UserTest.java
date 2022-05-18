package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void instantiatesDepartmentObjectsCorrectly_true() throws Exception {
        User testUser = setupUser();
        assertEquals(true, testUser instanceof User);
    }

    @Test
    public void getNameReturnsCorrectName() throws Exception {
        User testUser = setupUser();
        assertEquals("Ymelda", testUser.getName());
    }

    @Test
    public void getPositionReturnsCorrectPosition() throws Exception {
        User testUser = setupUser();
        assertEquals("Junior designer", testUser.getPosition());
    }

    @Test
    public void getRoleReturnsCorrectRole() throws Exception {
        User testUser = setupUser();
        assertEquals("UX designer", testUser.getRole());
    }

    @Test
    public void getDepartmentReturnsCorrectDepartment() throws Exception {
        User testUser = setupUser();
        assertEquals("UX", testUser.getDepartment());
    }
    @Test
    public void getDepartmentIdReturnsCorrectDepartmentId() throws Exception {
        User testUser = setupUser();
        assertEquals(1, testUser.getDepartmentId());
    }
    @Test
    public void setNameSetsCorrectName() throws Exception {
        User testUser = setupUser();
        testUser.setName("Nyash");
        assertNotEquals("Ymelda",testUser.getName());
    }
    @Test
    public void setPositionSetsCorrectPosition() throws Exception {
        User testUser = setupUser();
        testUser.setPosition("Developer");
        assertNotEquals("Junior designer",testUser.getPosition());
    }

    @Test
    public void setRoleSetsCorrectRole() throws Exception {
        User testUser = setupUser();
        testUser.setRole("Reconciliation");
        assertNotEquals("UX designer",testUser.getRole());
    }

    @Test
    public void setDepartmentSetsCorrectDepartment() throws Exception {
        User testUser = setupUser();
        testUser.setDepartment("HR");
        assertNotEquals("UX",testUser.getDepartment());
    }
    @Test
    public void setDepartmentIdSetsCorrectDepartmentId() throws Exception {
        User testUser = setupUser();
        testUser.setDepartmentId(7);
        assertNotEquals(1,testUser.getDepartment());
    }




    //HELPER
    public User setupUser (){
        return new User ("Ymelda", "Junior designer", "UX designer", "UX",1);
    }
}