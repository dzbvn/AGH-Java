package com.company;

import java.awt.*;

public class Snowflake implements XmasShape{
    int x;
    int y;
    double scale;
    //Color lineColor;
    //Color fillColor;

    @Override
    public void render(Graphics2D g2d) {
        // ustaw kolor wypełnienia
        GradientPaint grad = new GradientPaint(0,0,new Color(0,0,255),0,100, new Color(255,255,255));
        g2d.setPaint(grad);
        //g2d.setColor(this.fillColor);
        int x[]={305, 310, 310,  330, 335, 310, 310, 330, 335, 310, 310, 305};
        int y[]={0,   0,    20,  5,  10,  30,  40,  25,   32,  50,   110,  110};
        g2d.fillPolygon(x,y,x.length);

        g2d.translate(610,0);
        g2d.scale(-1,1);
        g2d.fillPolygon(x,y,x.length);
        ////////////
        g2d.translate(610, 220);
        g2d.scale(-1,-1);
        g2d.fillPolygon(x,y,x.length);

        g2d.translate(610,0);
        g2d.scale(-1,1);
        g2d.fillPolygon(x,y,x.length);
        ////////////
        g2d.translate(250,-210);
        g2d.rotate(Math.toRadians(60));
        g2d.fillPolygon(x,y,x.length);

        g2d.translate(610,0);
        g2d.scale(-1,1);
        g2d.fillPolygon(x,y,x.length);
        ////////////
        g2d.translate(550,-100);
        g2d.rotate(Math.toRadians(120));
        g2d.fillPolygon(x,y,x.length);

        g2d.translate(610,0);
        g2d.scale(-1,1);
        g2d.fillPolygon(x,y,x.length);
        ////////////
        g2d.translate(610,220);
        g2d.rotate(Math.toRadians(180));
        g2d.fillPolygon(x,y,x.length);

        g2d.translate(610,0);
        g2d.scale(-1,1);
        g2d.fillPolygon(x,y,x.length);
        ///////////
        g2d.translate(360,435);
        g2d.rotate(Math.toRadians(240));
        g2d.fillPolygon(x,y,x.length);

        g2d.translate(610,0);
        g2d.scale(-1,1);
        g2d.fillPolygon(x,y,x.length);


    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }
}
