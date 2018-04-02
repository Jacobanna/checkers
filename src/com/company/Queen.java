package com.company;

public class Queen extends Figure{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String toString(){
        return getColor() + " queen";
    }
}
