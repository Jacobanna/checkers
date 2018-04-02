package com.company;

public class Queen extends Figure{
    public Queen(String color) {
        super(color);
    }

    @Override
    public String toString(){
        return getColor() + " queen";
    }

//    @Override
//    public boolean equals(Object o) {
//        Queen q = (Queen) o;
//        return ;
//    }
}
