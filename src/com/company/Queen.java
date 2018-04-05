package com.company;

public class Queen extends Figure{
    public Queen(Color color) {
        super(color);
    }

    @Override
    public String toString(){
        return getColor() + " QUEEN";
    }

//    @Override
//    public boolean equals(Object o) {
//        Queen q = (Queen) o;
//        return ;
//    }
}
