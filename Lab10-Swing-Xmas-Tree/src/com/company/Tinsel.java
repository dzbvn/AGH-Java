package com.company;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Tinsel implements XmasShape{
    int x;
    int y;
    double scale;
    int amount;

    @Override
    public void render(Graphics2D g2d) {

        Shape Circle = new Ellipse2D.Double(5, 5, 12, 10);

        g2d.setColor(Color.yellow);
        g2d.draw(Circle);
        int i = 1;
        while(true){
            if(i > (amount-2)/3){
                g2d.translate(10,-1);
            }
            else {
                g2d.translate(10, 1);
            }
            g2d.setColor(Color.magenta);
            g2d.draw(Circle);
            i++;
            if(i >= amount){break;}
            if(i > (amount-2)/3){
                g2d.translate(10,-1);
            }
            else {
                g2d.translate(10, 1);
            }
            g2d.setColor(Color.cyan);
            g2d.draw(Circle);
            i++;
            if(i >= amount){break;}
            if(i > (amount-2)/3){
                g2d.translate(10,-1);
            }
            else {
                g2d.translate(10, 1);
            }
            g2d.setColor(Color.yellow);
            g2d.draw(Circle);
            i++;
            if(i >= amount){break;}
        }



    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        g2d.scale(scale,scale);
    }
}
