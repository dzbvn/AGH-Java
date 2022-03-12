package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.*;
import java.util.List;
import java.lang.Math;

public class DrawPanel extends JPanel {
    List<XmasShape> shapes = new ArrayList<>();
    /*public void paintComponent(Graphics g){
        g.setFont(new Font("Helvetica", Font.BOLD, 18));
        g.drawString("Hello World", 20, 20);
        System.out.println("painting");
        //linie
        g.drawLine(10,10,100,100);

        //elipsy
        g.setColor(Color.yellow);
        g.fillOval(100,101,30,30);
        g.setColor(Color.black);
        g.drawOval(100,101,30,30);

        //wieloboki
        int x[]={286,253,223,200,148,119,69,45,0};
        int y[]={0,101,89,108,79,95,66,80,56};
        g.fillPolygon(x,y,x.length);

    }*/
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        for(XmasShape s:shapes){
            s.draw((Graphics2D)g);
        }

        /*Graphics2D g2d= (Graphics2D)g;
        // zachowaj macierz przekształcenia
        AffineTransform mat = g2d.getTransform();
        // przesuń początek układu
        g2d.translate(100,100);
        // zastosuj skalowanie
        g2d.scale(.2,.2);
        // narysuj linie
        for(int i=0;i<12;i++){
            g2d.drawLine(0,0,100,100);
            g2d.rotate(2*Math.PI/12);
        }
        //oddtwórz poprzednie ustawienia transformacji układu współrzędnych
        g2d.setTransform(mat);

        g2d.translate(200,200);
        // zastosuj skalowanie
        g2d.scale(.2,.2);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("Serif", Font.PLAIN, 96);
        g2d.setFont(font);
        for(int i=0;i<12;i++){
            g2d.drawString("Happy new year",150,0);
            g2d.rotate(2*Math.PI/12);
        }
        // zachowaj macierz przekształcenia
        //AffineTransform mat = g2d.getTransform();
        // przesuń początek układu
        g2d.translate(200,200);
        // zastosuj skalowanie
        g2d.scale(.2,.2);
        g2d.setStroke(new BasicStroke(50, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
        for(int i=0;i<12;i++){
            //g2d.drawString("Happy new year",150,0);
            g2d.drawLine(0,0,100,100);
            g2d.rotate(2*Math.PI/12);
        }
        //oddtwórz poprzednie ustawienia transformacji układu współrzędnych
        g2d.setTransform(mat);*/

        /*Graphics2D g2d= (Graphics2D)g;
        AffineTransform mat = g2d.getTransform();
        GradientPaint grad = new GradientPaint(0,0,new Color(0,255,0),0,100, new Color(0,10,0));
        g2d.setPaint(grad);
        g2d.translate(0,50);
        g2d.scale(0.7,0.5);
        int x[]={286,286,223,200,148,119,69,45,0};
        int y[]={0,131,89,108,79,95,66,80,56};
        g2d.fillPolygon(x,y,x.length);
        g2d.translate(670,0);
        g2d.scale(-1,1);
        g2d.fillPolygon(x,y,x.length);
        g2d.setTransform(mat);*/

    }
    DrawPanel(){
        setBackground(new Color(0,0,50));
//        setOpaque(true);
    }

    void addBubble(int x, int y, double scale, Color fillColor, Color lineColor) {
        Bubble bubble = new Bubble();
        bubble.x = x;
        bubble.y = y;
        bubble.scale = scale;
        bubble.fillColor = fillColor;
        bubble.lineColor = lineColor;
        this.shapes.add(bubble);
    }
    void addStar(int x, int y, double scale, Color fillColor, Color lineColor) {
        Star star = new Star();
        star.x = x;
        star.y = y;
        star.scale = scale;
        star.fillColor = fillColor;
        star.lineColor = lineColor;
        this.shapes.add(star);
    }
    void addBranch(int x, int y, double scale) {
        Branch branch = new Branch();
        branch.x = x;
        branch.y = y;
        branch.scale = scale;
        //tree.fillColor = fillColor;
        //tree.lineColor = lineColor;
        this.shapes.add(branch);
    }
    void addTree(int x, int y, double scale, int parts){
        int curY = y;
        for(int i = 0; i < parts; i++){
            if(i == parts - 1){
                curY -= 10;
                this.addBranch(x + (int)(x/(4.5*(x/100))) * i, curY, 2.0 - (scale/(parts/2)) * i);
            }
            else if(i > 2 * parts/3){
                curY -= 20;
                this.addBranch(x + (int)(x/(4.5*(x/100))) * i, curY, 2.0 - (scale/(parts/2)) * i);
            }
            else if( i > parts/3){
                curY -= 30;
                this.addBranch(x + (int)(x/(4.5*(x/100))) * i, curY, 2.0 - (scale/(parts/2)) * i);
            }
            else {
                curY -= (int)y/10;
                this.addBranch(x + (int)(x/(4.5*(x/100))) * i, curY, 2.0 - (scale/(parts/2)) * i);
            }

        }

    }
    void addSnowflake(int x, int y, double scale){
        Snowflake sf = new Snowflake();
        sf.x = x;
        sf.y = y;
        sf.scale = scale;
        this.shapes.add(sf);
    }
    void addTrunk(int x, int y, double scale, Color fillColor, Color lineColor){
        Trunk trunk = new Trunk();
        trunk.x = x;
        trunk.y = y;
        trunk.scale = scale;
        trunk.fillColor = fillColor;
        trunk.lineColor = lineColor;
        this.shapes.add(trunk);
    }
    void addTinsel(int x, int y, double scale, int amount){
        Tinsel tinsel = new Tinsel();
        tinsel.x = x;
        tinsel.y = y;
        tinsel.scale = scale;
        tinsel.amount = amount;
        this.shapes.add(tinsel);
    }

    void addLight(int x, int y, double scale){
        Light light = new Light();
        light.x = x;
        light.y = y;
        light.scale = scale;
        this.shapes.add(light);
    }

    void addText(int x, int y, Color color, String val, Font font){
        Text text = new Text();
        text.x = x;
        text.y = y;
        text.val = val;
        text.font = font;
        text.color = color;
        this.shapes.add(text);

    }
}
