package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

import static com.company.Color.BLACK;
import static com.company.Color.RED;

public class UserDialogs {

    public static Color whoseMove = RED;

    public static Move getMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            switch (whoseMove) {
                case RED: {
                    System.out.println("RED PLAYER - enter next move in format A7B6:");
                    String userMove = scanner.nextLine().toUpperCase();
                    //TODO This is not error proof IF - using String with length 4 but with inccorect (ie 1111, aaa1,
                    //TODO bb1a) values will stop the program.4
                    if (userMove.length() == 4) {
                        int x1 = 8 - Integer.parseInt(userMove.substring(1, 2));
                        int y1 = userMove.charAt(0) - 65;
                        int x2 = 8 - Integer.parseInt(userMove.substring(3, 4));
                        int y2 = userMove.charAt(2) - 65;
                        Move move = new Move(x1, y1, x2, y2);
                        MoveValidator moveValidator = new MoveValidator(move, board);

                        if ((!(moveValidator.isValidMove()) && !(moveValidator.isPossibleMoveOver())) || moveValidator.moveColor() == BLACK) {
                                System.out.println("Wrong move HERE r!");
                                continue;
                        } else {
                            whoseMove = BLACK;
                            return move;
                        }
                    } else {
                        System.out.println("Wrong move!");
                        continue;
                    }
                }
                case BLACK: {
                    System.out.println("BLACK PLAYER - Enter next move in format A7B6:");
                    String userMove = scanner.nextLine().toUpperCase();
                    //TODO This is not error proof IF - using String with length 4 but with inccorect (ie 1111, aaa1,
                    //TODO bb1a) values will stop the program.
                    if (userMove.length() == 4) {
                        int x1 = 8 - Integer.parseInt(userMove.substring(1, 2));
                        int y1 = userMove.charAt(0) - 65;
                        int x2 = 8 - Integer.parseInt(userMove.substring(3, 4));
                        int y2 = userMove.charAt(2) - 65;
                        Move move = new Move(x1, y1, x2, y2);
                        MoveValidator moveValidator = new MoveValidator(move, board);

                        if ((!(moveValidator.isValidMove()) && !(moveValidator.isPossibleMoveOver())) || moveValidator.moveColor() == RED) {
                            System.out.println("Wrong move HERE b!");
                            continue;
                        } else {
                            whoseMove = RED;
                            return move;
                        }
                    } else {
                        System.out.println("Wrong move!");
                        continue;
                    }
                }
                default: {
                }
            }
        }
    }
}
