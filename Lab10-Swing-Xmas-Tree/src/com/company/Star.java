package com.company;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Star implements XmasShape{
    int x;
    int y;
    double scale;
    Color lineColor;
    Color fillColor;

    @Override
    public void render(Graphics2D g2d) {

        g2d.setColor(this.fillColor);
        int[] x  = {42,52,75,52,60,40,15,28,9,32,42};
        int [] y = {38,62,61,78,105,85,102,75,58,60,38};
        g2d.fillPolygon(x, y, 11);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }
}

