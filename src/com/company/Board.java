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
        Figure f1 = getFigure(x1, y1);
        Figure f2 = getFigure(x2,y2);
        Figure empty = new None();

        //Is x1,y1 NOT empty
        if (f1.equals(empty)){
            System.out.println("//Is x1,y1 NOT empty");
            return false;
        }

        //Is x2,y2 empty
        //TU PRZECIWNIE DO EQUALS
        if(f2.equals(empty)){
            System.out.println("//Is x2,y2 empty");
            return false;
        }

        //Is x1,y1 on board
        if (x1<0 || y1<0 || x1>7 || y1>7){
            System.out.println("//Is x1,y1 on board");
            return false;
        }

        //Is x2,y2 on board
        if (x2<0 || y2<0 || x2>7 || y2>7){
            System.out.println("//Is x1,y1 on board");
            return false;
        }

        //Validation for BLACK figures
        if(f1.getEnumColor() == ColorCheck.BLACK){
            if((x1+1)!=x2){
                System.out.println("//BLACK x1 x2 doesn't match");
                return false;
            }
            if((y1-1)!=y2 && (y1+1)!=y2){
                System.out.println("//BLACK y1 y2 doesn't match");
                return false;
            }
        }

        //Validation for RED figures
        if(f1.getEnumColor() == ColorCheck.RED){
            if((x1-1)!=x2){
                System.out.println("//RED x1 x2 doesn't match");
                return false;
            }
            if((y1-1)!=y2 && (y1+1)!=y2){
                System.out.println("//RED y1 y2 doesn't match");
                return false;
            }
        }

        return true;
    }

}
