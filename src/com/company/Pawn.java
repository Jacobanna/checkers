package com.company;

public class Pawn extends Figure{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String toString(){
        return getColor() + " pawn";
    }
}
