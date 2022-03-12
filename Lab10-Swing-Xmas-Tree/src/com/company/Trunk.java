package com.company;

import java.awt.*;

public class Trunk implements XmasShape{
    int x;
    int y;
    double scale;
    Color lineColor;
    Color fillColor;

    @Override
    public void render(Graphics2D g2d) {

        g2d.setColor(this.fillColor);
        int[] x  = {20,100,100,20};
        int [] y = {10,10,120,120};
        g2d.fillPolygon(x, y, x.length);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }
}
