package pl.ds.parser;

import org.junit.jupiter.api.Test;
import pl.ds.pojo.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    JAXBContext context = JAXBContext.newInstance(RSLogix5000Content.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();

    RSLogix5000Content rsLogix5000Content = (RSLogix5000Content) unmarshaller
            .unmarshal(new File("src/test/resources/test.L5X"));


    ParserTest() throws JAXBException {
    }

    @Test
    public void testControllerName() {
        //Given
        String controllerName = rsLogix5000Content.getController().getName();
        //When
        String expected = "Test_PLC_L5X";
        //Then
        assertEquals(expected, rsLogix5000Content.getController().getName());
    }

    @Test
    public void testControllerRevision() {
        //Given
        String majorRev = rsLogix5000Content.getController().getMajorRev();
        String minorRev = rsLogix5000Content.getController().getMinorRev();
        //When
        String expectedMajorRev = "31";
        String expectedMinorRev = "12";
        //Then
        assertEquals(expectedMajorRev, majorRev);
        assertEquals(expectedMinorRev, minorRev);
    }

    @Test
    public void testProgramExistInList() {
        //Given
        List<Program> programList = rsLogix5000Content.getController().getPrograms();
        //When
        String expectedProgramName = "P0010_MainProgram";
        //Then
        assertTrue(programList.stream().anyMatch(program -> program.getName().equals(expectedProgramName)));
    }

    @Test
    public void testTaskExistInList() {
        //Given
        List<Task> taskList = rsLogix5000Content.getController().getTasks();
        //When
        String expectedTaskName = "Continuous";
        //Then
        assertTrue(taskList.stream().anyMatch(task -> task.getName().equals(expectedTaskName)));
    }

    @Test
    public void testTagExistInList() {
        //Given
        List<Tag> tagList = rsLogix5000Content.getController().getTags();
        //When
        String expectedTagName = "Action_Messages";
        //Then
        assertTrue(tagList.stream().anyMatch(tag -> tag.getName().equals(expectedTagName)));
    }

}
