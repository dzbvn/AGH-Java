package com.company;

import java.awt.*;

public class Text implements XmasShape{
    int x;
    int y;
    String val;
    Font font;
    Color color;

    @Override
    public void render(Graphics2D g2d) {

        g2d.setFont(this.font);
        g2d.setColor(this.color);
        g2d.drawString(this.val, this.x, this.y);

    }

    @Override
    public void transform(Graphics2D g2d) {
        g2d.translate(x,y);
        //g2d.scale(scale,scale);

    }
}
