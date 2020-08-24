package com.sergey.kataev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        File usersDataFile = new File("Users.userdata");
        ArrayList<Integer> years = new ArrayList<>();
        HashMap<String, ArrayList<String>> users = new HashMap<>();
        try {
            Scanner scanner = new Scanner(usersDataFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] userRawData = line.split(",");
                String userName = userRawData[0];
                Integer year = Integer.parseInt(userRawData[1]);
                String phoneNumber = userRawData[2];
                years.add(year);
                if (users.containsKey(userName)){
                    users.get(userName).add(phoneNumber);
                }
                else {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(phoneNumber);
                    users.put(userName, temp);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка, нет файла Users.userdata");
        }
        years.sort(Integer::compareTo);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию: ");
        String userSurname = scanner.next();
        if(users.containsKey(userSurname)){
            ArrayList<String> userPhones = users.get(userSurname);
            if (userPhones.size() > 1){
                System.out.println("Номера телефонов данного человека: ");
            }
            else {
                System.out.println("Номер телефона данного человека");
            }
            for (String i:
                 userPhones) {
                System.out.println(i);
            }
        }
        else {
            System.out.println("Человека с такой фамилией нет в базе");
        }
        System.out.println("Введите год: ");
        Integer year = scanner.nextInt();
        Integer counter = years.size();
        for (int i = 0; i < years.size(); i++) {
            if(years.get(i)>=year){
                counter = i;
                break;
            }
        }
        System.out.println("С " + year + " года было зарегестрированно " + (years.size()-counter));
    }
}
