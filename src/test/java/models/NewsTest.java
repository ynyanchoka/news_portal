package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void instantiatesNewsObjectsCorrectly_true() throws Exception {
        News testNews = setupAltNews();
        assertEquals(true, testNews instanceof News);
    }
    @Test
    public void getTitleReturnsCorrectTitle() throws Exception {
        News testNews = setupAltNews();
        assertEquals("Training", testNews.getTitle());
    }
    @Test
    public void getDescriptionReturnsCorrectDescription() throws Exception {
        News testNews = setupAltNews();
        assertEquals("Training scheduled tomorrow", testNews.getDescription());
    }
    @Test
    public void getTypeReturnsCorrectType() throws Exception {
        News testNews = setupAltNews();
        assertEquals("General news", testNews.getType());
    }

    @Test
    public void setTitleSetsCorrectTitle() throws Exception {
        News testNews = setupAltNews();
        testNews.setTitle("Reconciliation");
        assertNotEquals("Training",testNews.getTitle());
    }


    @Test
    public void setDescriptionSetsCorrectTitle() throws Exception {
        News testNews = setupAltNews();
        testNews.setDescription("All departments needed");
        assertNotEquals("Training scheduled tomorrow",testNews.getDescription());
    }

    @Test
    public void setTypeSetsCorrectType() throws Exception {
        News testNews = setupAltNews();
        testNews.setType("Department news");
        assertNotEquals("General news",testNews.getType());
    }



    //HELPER
    public News setupNews (){
        return new News ("Training", "Training scheduled tomorrow",  "Department news");
    }
    public News setupAltNews (){
        return new News ("Training", "Training scheduled tomorrow", "General news");
    }

}