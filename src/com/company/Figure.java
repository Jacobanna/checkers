package com.company;

public class Figure{
    private String color;

    public Figure(String color) {
        if((color != null) && (color != "red") && (color != "black")){
            throw new IllegalArgumentException("If figure exists color must be red or black.");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}