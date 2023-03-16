package Gradingsys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Input the filepath location");
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        InputHandler inputHandler = new InputHandler(path);
        System.out.println(inputHandler.getContent());
        inputHandler.parseContent();
        List<String[]> studentsInfo = inputHandler.getParsedContent();
        String fileData = "";
        Course course = new Course(studentsInfo.get(0));
        fileData += course.getName() + " " + course.getTotal() ;
        System.out.println(course);
        for (int i = 1; i < studentsInfo.size(); i++) {
            Student student = new Student(studentsInfo.get(i),course.getTotal());
            student.calculateGPA();
            System.out.println(student.toString());
            fileData += "\n" + student.getName() + " " + student.getCode() + " " + student.getGpa() + " " + student.getGrade() ;
        }
        String fileName = course.getCode() + " " + course.getName() + " results.txt";
        OutputHandler outputHandler = new OutputHandler(fileName,fileData);
        System.out.println(fileData);
        System.out.println(inputHandler.getParsedContent().get(0)[2]);
        //ArrayList<String[]> data = StudentsParsing.parse(path);
        //System.out.println(data.get(4)[0]);
    }
}
