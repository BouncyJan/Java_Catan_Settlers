package main;

import java.awt.Color;
import java.awt.Label;
import java.util.Vector;

import javax.swing.JPanel;

public class GameMap extends JPanel {

    public  GameMap(){
    
        this.setLayout(null);
        this.setDoubleBuffered(true);

        int radius = 50;
        int hexWidth = (int) (Math.sqrt(3) * radius); // Exact width of a pointy-topped hex
        int hexHeight = radius * 2;
        
        Tile[] tiles = {
            new Tile(2,0,Color.red, 6),
            new Tile(3,0,Color.blue, 6),
            new Tile(1,1,Color.red, 5),
            new Tile(2,1,Color.yellow, 7),
            new Tile(3,1,Color.green, 8),
            new Tile(2,2,Color.blue, 8),
            new Tile(3,2,Color.green,5 ),
        };
        
        for (Tile tile : tiles) {
            int x = tile.col * hexWidth + (tile.row % 2 == 1 ? hexWidth / 2 : 0);
                
            int y = (int) (tile.row * (hexHeight * 0.78));

            HexagonPanel hex = new HexagonPanel(radius, tile.color);
            hex.setText(Integer.toString(tile.value));
            /* Label label = new Label(Integer.toString(tile.value));
            label.setLocation(20, 20);
            label.setBackground(null);
            hex.add(label); */
            hex.setBounds(x + 50, y + 50, hexWidth, hexHeight); // +50 for board padding
            this.add(hex);
        }

        this.repaint();
        this.revalidate();

    }

}
