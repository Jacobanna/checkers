package com.company;

public class MoveValidator {
    Move move;
    Board board;

    public MoveValidator(Move move, Board board) {
        this.move = move;
        this.board = board;
    }

    public boolean isValidMove() {
        Figure f1 = board.getFigure(move.getX1(), move.getY1());
        Figure f2 = board.getFigure(move.getX2(), move.getY2());

        //Is x1,y1 NOT empty
        if (f1 instanceof None) {
            return false;
        }

        //Is x2,y2 empty
        if (!(f2 instanceof None)) {
            return false;
        }

        //Is x1,y1 on board
        if (move.getX1() < 0 || move.getY1() < 0 || move.getX1() > 7 || move.getY1() > 7) {
            System.out.println("//Is x1,y1 on board");
            return false;
        }

        //Is x2,y2 on board
        if (move.getX2() < 0 || move.getY2() < 0 || move.getX2() > 7 || move.getY2() > 7) {
            return false;
        }

        //Validation for BLACK figures
        if (f1.getEnumColor() == ColorCheck.BLACK) {
            if ((move.getX1() + 1) != move.getX2()) {
                return false;
            }
            if ((move.getY1() - 1) != move.getY2() && (move.getY1() + 1) != move.getY2()) {
                return false;
            }
        }

        //Validation for RED figures
        if (f1.getEnumColor() == ColorCheck.RED) {
            if ((move.getX1() - 1) != move.getX2()) {
                return false;
            }
            if ((move.getY1() - 1) != move.getY2() && (move.getY1() + 1) != move.getY2()) {
                return false;
            }
        }

        return true;
    }
}
