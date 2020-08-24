package com.sergey.kataev;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserGenerator {
    public static void generateUsersFile() {
        File usersSurnamesInputFile = new File("UserSurnames.txt");
        try {
            if (!usersSurnamesInputFile.exists()) {
                usersSurnamesInputFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<User> users = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(usersSurnamesInputFile);
            while (scanner.hasNext()) {
                String userName = scanner.next();
                String phoneNumber = generatePhoneNumber();
                int year = generateYear();
                users.add(new User(phoneNumber, userName, year));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        File userFile = new File("Users.userdata");
        try {
            if (!userFile.exists()) {
                userFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            PrintWriter printWriter = new PrintWriter(userFile);
            for (User i :
                    users) {
                printWriter.println(i.toString());
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String generatePhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append("89");
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            phoneNumber.append(random.nextInt(9));
        }
        return phoneNumber.toString();
    }

    private static int generateYear() {
        Random random = new Random();
        return 1973 + random.nextInt(37);
    }
}
