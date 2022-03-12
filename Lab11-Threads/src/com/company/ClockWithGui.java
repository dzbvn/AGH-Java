package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.time.LocalTime;

import static java.awt.BasicStroke.CAP_ROUND;
import static java.awt.BasicStroke.JOIN_MITER;

public class ClockWithGui extends JPanel{
    LocalTime time = LocalTime.now();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock");
        ClockWithGui clockWithGui = new ClockWithGui();

        frame.setContentPane(clockWithGui);
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);

        clockWithGui.new ClockThread().start();


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(getWidth() / 2, getHeight() / 2);

        for(int i=1;i<13;i++){
            AffineTransform at = new AffineTransform();
            at.rotate(2*Math.PI/12*i);
            Point2D src = new Point2D.Float(0,-120);
            Point2D trg = new Point2D.Float();
            at.transform(src,trg);
            g2d.drawString(Integer.toString(i),(int)trg.getX()-5,(int)trg.getY()+3);
        }

        for(int i=1;i<61;i++){
            AffineTransform at2 = g2d.getTransform();
            g2d.rotate(2 * Math.PI / 60 * i);
            if(i % 5 == 0){
                g2d.setStroke(new BasicStroke(3, CAP_ROUND, JOIN_MITER));
            }
            else{
                g2d.setStroke(new BasicStroke(1, CAP_ROUND, JOIN_MITER));
            }
            g2d.drawLine(0,-135,0,-150);
            g2d.setTransform(at2);
        }

        AffineTransform saveAT = g2d.getTransform();
        g2d.setStroke(new BasicStroke(2, CAP_ROUND, JOIN_MITER));
        g2d.rotate(time.getSecond()%60*2*Math.PI/60);
        g2d.drawLine(0,0,0,-90);
        g2d.setTransform(saveAT);

        g2d.setStroke(new BasicStroke(4, CAP_ROUND, JOIN_MITER));
        g2d.rotate(time.getMinute()%60*2*Math.PI/60);
        g2d.rotate(time.getSecond()%(60*60)*2*Math.PI/(60*60));
        g2d.drawLine(0,0,0,-90);
        g2d.setTransform(saveAT);

        g2d.setStroke(new BasicStroke(4, CAP_ROUND, JOIN_MITER));
        g2d.rotate(time.getHour()%12*2*Math.PI/12);
        g2d.rotate(time.getMinute()%(12*60)*2*Math.PI/(12*60));
        g2d.rotate(time.getSecond()%(12*60*60)*2*Math.PI/(12*60*60));
        g2d.drawLine(0,0,0,-45);
        g2d.setTransform(saveAT);
    }



    class ClockThread extends Thread{
        @Override
        public void run() {
            for(;;){
                time = LocalTime.now();
                //poniewaz time jest atrybutem ClockWithGui, a ClockThread jest klasa wewnetrzna
                System.out.printf("%02d:%02d:%02d\n",time.getHour(),time.getMinute(),time.getSecond());
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
                //repaint odswieza, jest to metoda z JFrame
            }
        }
    }
}
