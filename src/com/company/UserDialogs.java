package com.company;

import java.util.Scanner;

public class UserDialogs {
    public static String getMove(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter next move in format A7B6:");
            String s = scanner.nextLine().toUpperCase();

            if(s.length() != 4){
                System.out.println("Wrong move!");
            } else {
                return s;
            }
        }
    }
}
