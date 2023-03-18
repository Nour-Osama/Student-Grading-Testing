package Gradingsys;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private String content;
    private List<String[]> parsedContent = new ArrayList<>();
    public InputHandler(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            // delete the last new line separator
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();
            content = stringBuilder.toString();
        }
        catch (IOException e) {
            System.out.println("Exception: " + e);
            content = "";
        }
    }
    public String getContent(){ return content;}
    public List<String[]> getParsedContent(){return parsedContent;}
    public void parseContent(){
        String[] lines = content.split("\n",0);
        for(int i =0; i < lines.length;i++){
            String line = lines[i];
            String[] csLine = line.split(",",0);
            String lastWord = csLine[csLine.length-1];
            String lastChar = lastWord.substring(lastWord.length() - 1);
            csLine[csLine.length-1] = (i < lines.length) ? lastWord.substring(0,lastWord.length()-1) : lastWord ;
            parsedContent.add(csLine);
        }
    }

}
