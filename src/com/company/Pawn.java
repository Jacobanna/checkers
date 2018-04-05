package com.company;

public class Pawn extends Figure{
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public String toString(){
        return getColor() + " PAWN";
    }

//    @Override
//    public boolean equals(Object o) {
//        Pawn p = (Pawn) o;
//        return ;
//    }

}
