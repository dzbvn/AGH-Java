package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*JFrame frame = new JFrame("Choinka");
        frame.setContentPane(new DrawPanel());
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);*/
        JFrame frame = new JFrame("Choinka");

        DrawPanel DPanel = new DrawPanel();

        for(int i = 0; i < 40; i++){
            int randX = ThreadLocalRandom.current().nextInt(-15, 1450);
            int randY = ThreadLocalRandom.current().nextInt(0, 750);
            DPanel.addSnowflake(randX, randY, 0.15);
        }

        DPanel.addTrunk(540, 540, 1, new Color(63,10,20), new Color(63,10,20));
        DPanel.addTree(400, 400, 1, 10);
        DPanel.addStar(540,-15,1.8,Color.yellow, Color.white);
        DPanel.addTinsel(505, 220, 2.5, 7);
        DPanel.addTinsel(460, 305, 2.5, 10);
        DPanel.addTinsel(410, 445, 2.5, 14);



        DPanel.addBubble(500, 500, 0.2, Color.blue, Color.blue);
        DPanel.addBubble(550, 400, 0.2, Color.yellow, Color.yellow);
        DPanel.addBubble(650, 280, 0.2, Color.yellow, Color.magenta);
        DPanel.addBubble(550, 200, 0.2, Color.green, Color.magenta);
        DPanel.addBubble(670, 430, 0.2, Color.white, Color.white);
        DPanel.addBubble(620, 360, 0.2, Color.cyan, Color.cyan);
        DPanel.addBubble(730, 415, 0.2, Color.magenta, Color.magenta);
        DPanel.addBubble(650, 500, 0.2, Color.green, Color.green);
        DPanel.addBubble(480, 420, 0.2, Color.magenta, Color.magenta);
        DPanel.addBubble(550, 280, 0.2, Color.orange, Color.orange);
        DPanel.addBubble(510, 350, 0.2, Color.blue, Color.blue);
        DPanel.addBubble(640, 190, 0.2, Color.pink, Color.pink);
        DPanel.addBubble(680, 380, 0.2, Color.red, Color.red);

        DPanel.addLight(590,180,0.16);
        DPanel.addLight(620,280,0.16);
        DPanel.addLight(610,420,0.16);
        DPanel.addLight(470,385,0.16);
        DPanel.addLight(720,360,0.16);
        DPanel.addLight(710,500,0.16);
        //DPanel.addSnowflake(-5, 0, 0.15);
        //DPanel.addSnowflake(400, 180, 0.15);
        //DPanel.addSnowflake(1450, 750, 0.15);
        DPanel.addText(450, 150, Color.cyan, "Wesołych", new Font("Helvetica", Font.BOLD, 60));
        DPanel.addText(480, 190, Color.cyan, "Świąt", new Font("Helvetica", Font.BOLD, 60));

        frame.setContentPane(DPanel);
        frame.setSize(1024, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
    }
}
