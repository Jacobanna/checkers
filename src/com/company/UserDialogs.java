package com.company;

import java.util.Scanner;

public class UserDialogs {
    public static Move getMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter next move in format A7B6:");
            String userMove = scanner.nextLine().toUpperCase();
            //TODO This is not error proof if - using String with length 4 but with inccorect values will stop the
            // program.
            if (userMove.length() == 4) {
                int x1 = 8 - Integer.parseInt(userMove.substring(1, 2));
                int y1 = userMove.charAt(0) - 65;
                int x2 = 8 - Integer.parseInt(userMove.substring(3, 4));
                int y2 = userMove.charAt(2) - 65;
                Move move = new Move(x1, y1, x2, y2);
                MoveValidator moveValidator = new MoveValidator(move, board);

                if (!(moveValidator.isValidMove())) {
                    System.out.println("Wrong move!");
                } else {
                    return move;
                }
            } else {
                System.out.println("Wrong move!");
            }
        }
    }

}
