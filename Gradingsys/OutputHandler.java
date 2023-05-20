package Gradingsys;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class OutputHandler {
    private String name;
    private String data;
    public OutputHandler(String name,String data){
        this.name = name;
        this.data = data;
        createFile();
        writeFile();
    }
    private void writeFile(){
        try {
            FileWriter myWriter = new FileWriter(name);
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private void createFile(){
        try {
            File file = new File(name);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

