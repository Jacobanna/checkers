package com.company;

public class Game {
    public void playGame() {
        Board board = new Board();
        board.initialBoard();

        while (true) {
            System.out.println(board);
            Move move = UserDialogs.getMove(board);
            board.move(move,board);
        }
    }
}
