/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.assignment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Balls extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1503263973313757150L;
	private List<Ball> ballsUp;

    public Balls(int numberOfCircle, int minRange, int maxRange) {
        ballsUp = new ArrayList<Ball>(25);

        //10 + random(90)
        for (int index = 0; index < numberOfCircle; index++) {
            ballsUp.add(new Ball(new Color(random(255), random(255), random(255)), minRange, maxRange));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Ball ball : ballsUp) {
            ball.paint(g2d);
        }
        g2d.dispose();
    }

    public List<Ball> getBalls() {
        return ballsUp;
    }
    
    public static int random(int maxRange) {
        return (int) Math.round((Math.random() * maxRange));
    }
}
