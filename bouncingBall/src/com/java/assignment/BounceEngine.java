/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.assignment;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.SwingUtilities;

public class BounceEngine implements Runnable {

    private Balls parent;

    public BounceEngine(Balls parent) {
        this.parent = parent;
    }

    @Override
    public void run() {

        int width = getParent().getWidth();
        int height = getParent().getHeight();

        // Randomize the starting position...
        for (Ball ball : getParent().getBalls()) {
            int x = random(width);
            int y = random(height);

            Dimension size = ball.getSize();

            if (x + size.width > width) {
                x = width - size.width;
            }
            if (y + size.height > height) {
                y = height - size.height;
            }

            ball.setLocation(new Point(x, y));

        }

        while (getParent().isVisible()) {

            // Repaint the balls pen...
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    getParent().repaint();
                }
            });

            // This is a little dangrous, as it's possible
            // for a repaint to occur while we're updating...
            for (Ball ball : getParent().getBalls()) {
                move(ball);
            }

            // Some small delay...
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }

        }

    }

    public Balls getParent() {
        return parent;
    }

    public void move(Ball ball) {

        Point p = ball.getLocation();
        Point speed = ball.getSpeed();
        Dimension size = ball.getSize();

        int vx = speed.x;
        int vy = speed.y;

        int x = p.x;
        int y = p.y;

        if (x + vx < 0 || x + size.width + vx > getParent().getWidth()) {
            vx *= -1;
        }
        if (y + vy < 0 || y + size.height + vy > getParent().getHeight()) {
            vy *= -1;
        }
        x += vx;
        y += vy;

        ball.setSpeed(new Point(vx, vy));
        ball.setLocation(new Point(x, y));

    }
    
    public static int random(int maxRange) {
        return (int) Math.round((Math.random() * maxRange));
    }
        
}