package com.company;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.initialBoard();
        System.out.println(board);

        board.move(2,1,3,2);
        System.out.println(board);
    }
}