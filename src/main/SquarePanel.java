package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

class SquarePanel extends JPanel {
    private final int sideLength;

    public SquarePanel(int sideLength, Color color) {
        this.sideLength = sideLength;
        setBackground(color);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(sideLength, sideLength);
    }
}