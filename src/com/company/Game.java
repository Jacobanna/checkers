package com.company;

public class Game {
    public void playGame(){
        Board board = new Board();
        board.initialBoard();

        while(true){
            System.out.println(board);
            String move = UserDialogs.getMove();
            int x1 = 8-Integer.parseInt(move.substring(1,2));
            int y1 = move.charAt(0)-65;
            int x2 = 8-Integer.parseInt(move.substring(3,4));
            int y2 = move.charAt(2)-65;

            board.move(x1,y1,x2,y2);


        }
    }
}
