package main;

import java.awt.Color;

public class Tile {
    public int col;
    public int row;
    public Color color;
    public int value;

    public Tile(int col, int row, Color color, int value){
        this.col = col;
        this.row = row;
        this.color = color;
        this.value = value;
    }
}
