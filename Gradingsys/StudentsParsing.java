package Gradingsys;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentsParsing {
    public static ArrayList<String[]> parse(String file)
    {
        String line;
        ArrayList<String[]> arrayData = new ArrayList<String[]>();
        boolean hasCriticalErrors = false;
        try
        {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferreader = new BufferedReader(fileReader);
            //Parsing the header line
            String[] initial_line = bufferreader.readLine().trim().split(",");
            //Check the course code
            if(!isAlpha(initial_line[1].substring(0,3)) && !isNumeric(initial_line[1].substring(3,6))){
                System.out.println("Error with the course code");
            }
            //Check the Fullmark
            if(Double.parseDouble(initial_line[2]) != 100){
                System.out.println("Invalid Full mark, Should be 100");
                initial_line[2] = "100";
            }
            arrayData.add(initial_line);

            //Parsing the student data
            while((line = bufferreader.readLine()) != null){
                hasCriticalErrors = false;
                line = line.trim();
                String[] input = line.split(",");
                //Check for validity of name
                if(!isAlpha(input[0])){
                    System.out.println("Error with "+input[0]);
                    System.out.println("name should contain alphabet and spaces only");
                    hasCriticalErrors = true;
                }
                //Validation of the student code
                if(input[1].length() == 8 || input[1].length() == 7){
                    if(!isNumeric(input[1].substring(0,7))) {
                        System.out.println("Error with the student code");
                        hasCriticalErrors = true;
                    }
                    else if((input[1].length() == 8))
                    {
                        if (!isAlpha(input[1].substring(7, 8)))
                            hasCriticalErrors = true;
                    }
                }
                else{
                    System.out.println("Error with the student code length");
                    hasCriticalErrors = true;
                }

                //Checking marks for errors
                if(Double.parseDouble(input[2]) < 0 || Double.parseDouble(input[2]) > 10)
                    System.out.println("Error with the student activites mark of "+input[0]);
                if(Double.parseDouble(input[3]) < 0 || Double.parseDouble(input[3]) > 10)
                    System.out.println("Error with the Practical mark of "+input[0]);
                if(Double.parseDouble(input[4]) < 0 || Double.parseDouble(input[4]) > 20)
                    System.out.println("Error with the Midterm mark of "+input[0]);
                if(Double.parseDouble(input[5]) < 0 || Double.parseDouble(input[5]) > 60)
                    System.out.println("Error with the Final mark of "+input[0]);

                //If no errors, input the data into the arraylist
                if(!hasCriticalErrors){
                    arrayData.add(input);
                }
            }
            bufferreader.close();
        }
        catch(IOException e)
        {
            System.out.println("Exception: " +e);
        }
        return arrayData;
    }
    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z ]*");
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
