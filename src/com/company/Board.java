package com.company;

import java.util.ArrayList;

public class Board {
    private ArrayList<BoardRow> boardRows;

    public Board() {
        BoardRow empty = new BoardRow();
        ArrayList<BoardRow> emptyRows = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            emptyRows.add(empty);
        }
        this.boardRows = emptyRows;
    }

    public Board(ArrayList<BoardRow> boardRows) {
        if (boardRows.size() != 8) {
            throw new IllegalArgumentException("Need all 8 rows initialized");
        }
        this.boardRows = boardRows;
    }

    public ArrayList<BoardRow> getBoardRows() {
        return this.boardRows;
    }

    public Figure getFigure(int row, int col) {
        ArrayList<BoardRow> boardRows = getBoardRows();
        BoardRow boardRow = boardRows.get(row);
        ArrayList<Figure> figures = boardRow.getFigures();
        Figure figure = figures.get(col);
        return figure;
    }

    public void setFigure(int row, int col, Figure figure) {
        ArrayList<BoardRow> boardRows = getBoardRows();
        BoardRow boardRow = boardRows.get(row);
        ArrayList<Figure> figures = boardRow.getFigures();
        figures.set(col, figure);
    }

    @Override
    public String toString() {
        String boardVisualisation = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0) {
                    boardVisualisation += "  A  B  C  D  E  F  G  H\n";
                    break;
                }

                if (j == 0) {
                    boardVisualisation += Integer.toString(9 - i) + " ";
                    continue;
                }

                Figure tempFigure = getFigure(i - 1, j - 1);
                String temp = tempFigure.toString();
                if (temp.equals("empty")) {
                    boardVisualisation += "   ";
                } else if (temp.equals("red pawn")) {
                    boardVisualisation += "RP ";
                } else if (temp.equals("black pawn")) {
                    boardVisualisation += "BP ";
                } else if (temp.equals("red queen")) {
                    boardVisualisation += "RQ ";
                } else if (temp.equals("black queen")) {
                    boardVisualisation += "BQ ";
                } else {
                    System.out.println("Error printing board.");
                }

                if (j == 8) {
                    boardVisualisation += "\n";
                }
            }
        }

        return boardVisualisation;
    }

    public void initialBoard() {
        Figure empty = new None();
        Figure redPawn = new Pawn("red");
        Figure blackPawn = new Pawn("black");

        boardRows = new ArrayList<>();

        for(int i=0; i<8; i++){
            ArrayList<Figure> figureList = new ArrayList<>();
            for(int k=0; k<8; k++){
                figureList.add(empty);
            }
            boardRows.add(new BoardRow(figureList));
        }

        Board initialBoard = new Board(boardRows);
        for(int i=0; i<8; i++){
            if(i == 0 || i == 2){
                for(int j=0; j<8; j++)
                    if(j%2 == 1){
                        initialBoard.setFigure(i,j,blackPawn);
                    }
            } else if (i == 1) {
                for(int j=0; j<8; j++)
                    if(j%2 == 0){
                        initialBoard.setFigure(i,j,blackPawn);
                    }
            } else if (i == 5 || i == 7){
                for(int j=0; j<8; j++)
                    if(j%2 == 0){
                        initialBoard.setFigure(i,j,redPawn);
                    }
            } else if (i == 6) {
                for(int j=0; j<8; j++)
                    if(j%2 == 1){
                        initialBoard.setFigure(i,j,redPawn);
                    }
            } else {
//                Nothing happens for i==3 and i==4
            }
        }




    }

    public boolean move(int x1, int y1, int x2, int y2) {
        if (isValidMove(x1, y1, x2, y2)) {
            Figure f = getFigure(x1, y1);
            setFigure(x2, y2, f);
            setFigure(x1, y1, new None());

            return true;
        } else {
            return false;
        }
    }

    private boolean isValidMove(int x1, int y1, int x2, int y2) {
        Figure f = getFigure(x1, y1);
        Figure empty = new None();
        if (f == empty){
            return false;
        }
        if (x1<0 || y1<0 || x2>7 || y2>7){
            return false;
        }
        if(x1>x2 || (x1+1)>x2){
            return false;
        }

        return true;
    }

}
