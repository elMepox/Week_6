package com.sergey.kataev;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner scanner = new Scanner(input);
            ArrayList<String> inputStrings = new ArrayList<>();
            while (scanner.hasNext()){
                inputStrings.add(scanner.next());
            }
            inputStrings.sort(String::compareTo);
            File output = new File("output.txt");
            if(!output.exists()){
                try {
                    output.createNewFile();
                }
                catch (IOException e ){
                    System.out.println(e.getMessage());
                }
            }
            PrintWriter outputPrintWriter = new PrintWriter(output);
            for (String i:
                 inputStrings) {
                outputPrintWriter.println(i);
            }
            outputPrintWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
