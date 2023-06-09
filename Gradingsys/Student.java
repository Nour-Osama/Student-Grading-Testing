package Gradingsys;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String name;
    private String code;
    private int[] marks;
    private boolean valid;
    private double gpa;
    private String grade;
    private boolean validateName(String name){
        boolean isValid = true;
        //check if name contains only alphabet letters
        try {
            if (!Validation.isAlpha(name)) {
                System.out.println("Error with name: " + name);
                System.out.println("name should contain alphabet and spaces only");
                isValid = false;
            }
        }
        catch(StringIndexOutOfBoundsException e){
            isValid = false;
            valid = false;
            System.out.println("Invalid student name");
        }
        return isValid;
    }
    private boolean validateCode(String code){
        boolean isValid = true;
        try {
            if (code.length() == 7 || code.length() == 8) {
                if (!Validation.isNumeric(code.substring(0, 7))) {
                    System.out.println("Error with the student code");
                    isValid = false;
                    valid = false;
                }
                if (code.length() == 8) {
                    if(code.charAt(7) != 's'){
                        valid = false;
                        isValid = false;
                    }
                }
            }
            else{
                valid = false;
                isValid = false;
                System.out.println("Invalid code length");
            }
        }
        catch(Exception e){
            isValid = false;
            valid = false;
            System.out.println("invalid student code");
        }
        return isValid;
    }
    private boolean validateMarks(String[] marks,int maxTotal){
        boolean isValid = true;
        try {
            //Checking marks for errors
            if (Double.parseDouble(marks[0]) < 0 || Double.parseDouble(marks[0]) > 10) {
                System.out.println("Error with the student activities mark of " + this.name);
                valid = false;
                isValid = false;
            }
            if (Double.parseDouble(marks[1]) < 0 || Double.parseDouble(marks[1]) > 10) {
                System.out.println("Error with the Practical mark of " + this.name);
                valid = false;
                isValid = false;
            }
            if (Double.parseDouble(marks[2]) < 0 || Double.parseDouble(marks[2]) > 20) {
                System.out.println("Error with the Midterm mark of " + this.name);
                valid = false;
                isValid = false;
            }
            if (Double.parseDouble(marks[3]) < 0 || Double.parseDouble(marks[3]) > 60) {
                System.out.println("Error with the Final mark of " + this.name);
                valid = false;
                isValid = false;
            }

        }
        catch(Exception e){
            isValid = false;
            valid = false;
            System.out.println("invalid marks");
            return isValid;
        }
        return isValid;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", marks=" + Arrays.toString(marks) +
                ", valid=" + valid +
                ", gpa=" + gpa +
                ", grade='" + grade + '\'' +
                '}';
    }


    public double getGpa() {
        return gpa;
    }

    public String getGrade() {
        return grade;
    }

    public Student(String[] info, int maxTotal) {
        if(info.length != 6){
            this.valid = false;
            this.name = "INVALID FORMAT";
            this.code = "INVALID FORMAT";
            this.marks = new int[]{-1, -1, -1, -1};
        }
        else{
            this.valid = true;
            this.name = (validateName(info[0])) ? info[0] : "Invalid Name";
            this.code = (validateCode(info[1])) ? info[1] : "Invalid Code";
            this.marks = validateMarks(new String[]{info[2], info[3], info[4], info[5]}, maxTotal) ?
                    new int[]{Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                            Integer.parseInt(info[4]), Integer.parseInt(info[5])} :
                    new int[]{-1, -1, -1, -1};
        }
        this.gpa = -1;
        this.grade = "U";
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int[] getMarks() {
        return marks;
    }

    public boolean isValid() {
        return valid;
    }
    public void calculateGPA(){
        if(valid){
            int total_marks = 0;
            for ( int mark :marks){
                total_marks += mark;
            }
            // gpa table
            if(total_marks < 60){
                gpa = 0.0;
                grade = "F";
            }
            else if(total_marks >= 60 && total_marks <64){
                gpa = 1.0;
                grade = "D";
            }
            else if(total_marks >= 64 && total_marks <67){
                gpa = 1.3;
                grade = "D+";
            }
            else if(total_marks >= 67 && total_marks <70){
                gpa = 1.7;
                grade = "C-";
            }
            else if(total_marks >= 70 && total_marks <73){
                gpa = 2.0;
                grade = "C";
            }
            else if(total_marks >= 73 && total_marks <76){
                gpa = 2.3;
                grade = "C+";
            }
            else if(total_marks >= 76 && total_marks <80){
                gpa = 2.7;
                grade = "B-";
            }
            else if(total_marks >= 80 && total_marks <84){
                gpa = 3.0;
                grade = "B";
            }
            else if(total_marks >= 84 && total_marks <89){
                gpa = 3.3;
                grade = "B+";
            }
            else if(total_marks >= 89 && total_marks <93){
                gpa = 3.7;
                grade = "A-";
            }
            else if(total_marks >= 93 && total_marks <97){
                gpa = 4.0;
                grade = "A";
            }
            else if(total_marks >=97 && total_marks <=100){
                gpa = 4.0;
                grade = "A+";
            }
        }
    }
}
