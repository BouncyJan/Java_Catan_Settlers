package main;

import java.awt.*;
import javax.swing.*;

class HexagonPanel extends JPanel {
    private final int radius;
    private final Color color;
    public String text;

    public HexagonPanel(int radius, Color color) {
        this.radius = radius;
        this.color = color;
        setBackground(new Color(0, 0, 0, 0)); // Transparent background
        setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize() {
        // Width and height based on a pointy-topped or flat-topped hexagon bounding box
        int diameter = radius * 2;
        return new Dimension(diameter, diameter);
    }

    public void setText(String text){
        this.text = text;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Polygon hex = new Polygon();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        double[] sin = {-1, -0.5, 0.5, 1, 0.5, -0.5, -1};
        double[] cos = {0, 0.866, 0.866, 0, -0.866, -0.866, 0};

        for (int i = 0; i < 6; i++) {
            int x = (int) (centerX + radius * cos[i]);
            int y = (int) (centerY + radius * sin[i]);
            hex.addPoint(x, y);
        }

        /* 
        // Calculate points for a pointy-topped hexagon
        for (int i = 0; i < 6; i++) {
            // Angle for each vertex (subtracting Math.PI / 2 makes it pointy-topped)
            double angle = 2 * Math.PI / 6 * i - Math.PI / 2;
            int x = (int) (centerX + radius * Math.cos(angle));
            int y = (int) (centerY + radius * Math.sin(angle));
            hex.addPoint(x, y);
        }
        */

        g2d.setColor(color);
        g2d.fillPolygon(hex);
        
        g2d.setColor(this.color);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawPolygon(hex);

        if (this.text != null && !this.text.isEmpty()) {
            g2d.setColor(Color.WHITE); // Text color (change to BLACK if background is yellow/light)
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            FontMetrics fm = g2d.getFontMetrics();
            int textX = centerX - (fm.stringWidth(this.text) / 2);
            int textY = centerY + ((fm.getAscent() - fm.getDescent()) / 2);
            g2d.drawString(this.text, textX, textY);
        }

        g2d.dispose();
    }
}