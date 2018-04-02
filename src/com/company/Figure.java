package com.company;

public class Figure{
    private String color;
    private Enum enumColor;

    public Figure(String color) {
        if((color != null) && (color != "red") && (color != "black")){
            throw new IllegalArgumentException("If figure exists color must be red or black.");
        }

        if(color == "red"){
            enumColor = ColorCheck.RED;
        }

        if(color == "black"){
            enumColor = ColorCheck.BLACK;
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Enum getEnumColor(){
        return enumColor;
    }
}