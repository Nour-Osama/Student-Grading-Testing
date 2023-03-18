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
        try
        {
            FileReader fileReader = new FileReader(file);
            System.out.println();
            BufferedReader bufferreader = new BufferedReader(fileReader);

            //Parsing the student data
            while((line = bufferreader.readLine()) != null){
                line = line.trim();
                String[] input = line.split(",");
                arrayData.add(input);
            }
            bufferreader.close();
        }
        catch(IOException e)
        {
            System.out.println("Exception: " +e);
            System.out.println("Invalid file path");
        }
        return arrayData;
    }
}
