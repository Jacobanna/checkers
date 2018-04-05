package com.company;

import static com.company.Color.BLACK;
import static com.company.Color.RED;

public class Figure{
    private Color color;

    public Figure(Color color) {
        if((color != null) && (color != RED) && (color != BLACK)){
            throw new IllegalArgumentException("If figure exists color must be red or black.");
        }

        if(color == RED){
            color = color.RED;
        }

        if(color == BLACK){
            color = color.BLACK;
        }
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}