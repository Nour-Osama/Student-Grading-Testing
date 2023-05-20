package Gradingsys_test;
import static org.junit.jupiter.api.Assertions.*;

import Gradingsys.InputHandler;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class InputHandlerTest {
    @Test
    void inputHandlerTest1() {
        String path =  System.getProperty("user.dir") + "\\Student-Grading-Testing-master\\InputHandlerTest.txt";
        InputHandler inputHandler = new InputHandler(path);
        String s = "Valid";
        assertEquals(s, inputHandler.getContent().replaceAll("\r", ""));
    }
    @Test
    void inputHandlerTest2() {
        String path =  System.getProperty("user.dir") + "\\Student-Grading-Testing-master\\InputHandlerTestNotReal.txt";
        InputHandler inputHandler = new InputHandler(path);
        String s = "";
        assertEquals(s, inputHandler.getContent().replaceAll("\r", ""));
    }
    @Test
    void inputHandlerTest3() {
        String path =  System.getProperty("user.dir") + "\\Student-Grading-Testing-master\\InputHandlerParsedContent.txt";
        InputHandler inputHandler = new InputHandler(path);
        inputHandler.parseContent();
        List<String> actual = Arrays.asList(inputHandler.getParsedContent().get(0));
        List<String> expected = Arrays.asList("Software Testing","CSE337s","100");
        assertEquals(expected, actual);
    }
}
