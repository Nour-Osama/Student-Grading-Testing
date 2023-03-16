package Gradingsys;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Input the filepath location");
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        ArrayList<String[]> data = StudentsParsing.parse(path);
        System.out.println(data.get(4)[0]);
    }
}
