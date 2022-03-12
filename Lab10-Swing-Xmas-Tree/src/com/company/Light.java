package com.company;

import java.awt.*;

public class Light implements XmasShape{
    int x;
    int y;
    double scale;

    @Override
    public void render(Graphics2D g2d) {

        g2d.setColor(Color.white);
        int[] x  = {20,90,90,20};
        int[] y = {10,10,125,125};
        g2d.fillPolygon(x, y, x.length);

        g2d.setColor(Color.orange);
        int[] x2 = {50, 38, 36, 35, 42, 54, 65, 68, 65, 53, 26, 12, 6, 7, 12, 22, 32};
        int[] y2 = {113, 84, 73, 57, 50, 45, 39, 26, 15, 6, 5, 10, 27, 46, 67, 86, 98};
        g2d.scale(1,-1);
        g2d.translate(20,-16);
        g2d.fillPolygon(x2, y2, x2.length);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }
}
