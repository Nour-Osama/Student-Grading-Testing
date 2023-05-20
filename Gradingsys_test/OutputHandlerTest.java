package Gradingsys_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Gradingsys.OutputHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OutputHandlerTest {
    @Test
    public void outputHandlerTest() throws IOException {
        String fileData = "data";
        String fileName = "testfile.txt";
        OutputHandler outputHandler = new OutputHandler(fileName, fileData);
        Path filePath = Paths.get(fileName);
        assertTrue(Files.exists(filePath));
        assertEquals(fileData, Files.readString(filePath));
        Files.delete(filePath);
    }
}
