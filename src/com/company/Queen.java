package com.company;

public class Queen extends Figure{
    public Queen(Color color) {
        super(color);
    }

    @Override
    public String toString(){
        return getColor() + " QUEEN";
    }
}
