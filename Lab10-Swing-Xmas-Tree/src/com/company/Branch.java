package com.company;

import java.awt.*;

public class Branch implements XmasShape{
    int x;
    int y;
    double scale;
    //Color lineColor;
    //Color fillColor;

    @Override
    public void render(Graphics2D g2d) {
        // ustaw kolor wypełnienia
        GradientPaint grad = new GradientPaint(0,0,new Color(0,255,0),0,100, new Color(0,10,0));
        g2d.setPaint(grad);
        //g2d.setColor(this.fillColor);
        int x[]={300,300,223,200,148,119,69,45,0};
        int y[]={0,131,89,108,79,95,66,80,56};
        g2d.fillPolygon(x,y,x.length);
        g2d.translate(600,0);
        g2d.scale(-1,1);
        g2d.fillPolygon(x,y,x.length);
    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale/3,scale);
    }
}
