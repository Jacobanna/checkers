package com.company;

public class Game {
    public void playGame() {
        Board board = new Board();
        board.initialBoard();

        while (true) {
            System.out.println(board);
            Move move = UserDialogs.getMove(board);
            MoveValidator moveValidator = new MoveValidator(move, board);
            moveValidator.move();
        }
    }
}
