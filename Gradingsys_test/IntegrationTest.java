package Gradingsys_test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Gradingsys.*;

import java.util.List;

class IntegrationTest {
    @Test
    void InputHandlerCourseTest() {
        String path =  System.getProperty("user.dir") + "\\Student-Grading-Testing-master\\InputHandlerCourseTest.txt";
        InputHandler inputHandler = new InputHandler(path);
        inputHandler.parseContent();
        List<String[]> studentsInfo = inputHandler.getParsedContent();
        Course course = new Course(studentsInfo.get(0));
        String s="Course{name='Software Testing', code='CSE337s', total=100, valid=true}";
        assertEquals(s, course.toString());
    }
    @Test
    void InputHandlerStudentTest() {
        String path =  System.getProperty("user.dir") + "\\Student-Grading-Testing-master\\InputHandlerStudentTest.txt";
        InputHandler inputHandler = new InputHandler(path);
        inputHandler.parseContent();
        List<String[]> studentsInfo = inputHandler.getParsedContent();
        Course course = new Course(studentsInfo.get(0));
        Student student = new Student(studentsInfo.get(1),course.getTotal());
        String s="Student{name='Invalid Name', code='1900180s', marks=[-1, -1, -1, -1], valid=false, gpa=-1.0, grade='U'}";
        assertEquals(s, student.toString());
    }
    @Test
    void InputHandlerGPATest() {
        String path =  System.getProperty("user.dir") + "\\Student-Grading-Testing-master\\InputHandlerGPATest.txt";
        InputHandler inputHandler = new InputHandler(path);
        inputHandler.parseContent();
        List<String[]> studentsInfo = inputHandler.getParsedContent();
        Course course = new Course(studentsInfo.get(0));
        Student student = new Student(studentsInfo.get(1),course.getTotal());
        student.calculateGPA();
        String s="Student{name='Mohamed  Farouk', code='1901472s', marks=[10, 10, 20, 60], valid=true, gpa=4.0, grade='A+'}";
        assertEquals(s, student.toString());
    }
    @Test
    void InputOutputHandlerTest() {
        String path =  System.getProperty("user.dir") + "\\Student-Grading-Testing-master\\InputOutputHandlerTest.txt";
        InputHandler inputHandler = new InputHandler(path);
        inputHandler.parseContent();
        List<String[]> studentsInfo = inputHandler.getParsedContent();
        Course course = new Course(studentsInfo.get(0));
        Student student = new Student(studentsInfo.get(1),course.getTotal());
        student.calculateGPA();
        String fileName = course.getCode() + " " + course.getName() + " results.txt";
        OutputHandler outputHandler = new OutputHandler(fileName,student.toString());
        inputHandler = new InputHandler(System.getProperty("user.dir") + "\\"+fileName);
        String s="Student{name='Mohamed  Adel', code='1901472s', marks=[10, 10, 20, 59], valid=true, gpa=4.0, grade='A+'}";
        assertEquals(s, inputHandler.getContent().replaceAll("\r", ""));
    }
}
