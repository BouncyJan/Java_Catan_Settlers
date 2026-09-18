package main;

import java.awt.Color;
import javax.swing.JFrame;

public class UI {
 
    GameManager gm;

    JFrame window;


    public UI(GameManager gm){

        this.gm = gm;

        createMainField();

        this.window.setVisible(true);

    }

    public void createMainField(){
        
        this.window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setResizable(false);
        window.setTitle("Catan Settlers");
        window.setLayout(null);
        
        window.getContentPane().setBackground(Color.BLACK);

        Board map = new Board();
        map.setBounds(100, 100, 700, 700);
        window.add(map);
    
        window.setLocationByPlatform(true);
        window.setSize(800, 800);
        window.setLocationRelativeTo(null);

        
        //window.pack();
    }


}
