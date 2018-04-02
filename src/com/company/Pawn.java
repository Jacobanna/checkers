package com.company;

public class Pawn extends Figure{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String toString(){
        return getColor() + " pawn";
    }

//    @Override
//    public boolean equals(Object o) {
//        Pawn p = (Pawn) o;
//        return ;
//    }

}
