package com.company;

public class None extends Figure{
    public None() {
        super(null);
    }

    @Override
    public String toString(){
        return "empty";
    }

//    @Override
//    public boolean equals(Object o) {
//        None n = (None) o;
//        return ;
//    }
}