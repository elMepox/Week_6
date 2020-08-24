package com.sergey.kataev;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            if (!input.exists()){
                input.createNewFile();
            }
            Scanner scanner = new Scanner(input);
            ArrayList<Integer> inputDataList = new ArrayList<>();
            while (scanner.hasNext()){
                Integer temp = scanner.nextInt();
                if(temp%2 == 1){
                    inputDataList.add(temp);
                }
            }
            scanner.close();
            PrintWriter pw = new PrintWriter(input);
            for (Integer i :
                    inputDataList) {
                pw.println(i);
            }
            pw.close();

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
