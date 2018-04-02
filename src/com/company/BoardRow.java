package com.company;

import java.util.ArrayList;

public class BoardRow{
    private ArrayList<Figure> figures;

    public BoardRow(){
        Figure none = new None();
        ArrayList<Figure> empty = new ArrayList<>();
        for(int i=0; i<8; i++){
            empty.add(none);
        }
        this.figures = empty;
    }

    public BoardRow(ArrayList<Figure> figures) {
        if(figures.size() != 8){
            throw new IllegalArgumentException("Need all 8 elements in a row selected.");
        }
        this.figures = figures;
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }
}