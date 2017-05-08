/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.assignment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class Ball {

    private Color color;
    private Point location;
    private Dimension size;
    private Point speed;

    public Ball(Color color, int minRange, int MaxRange) {

        setColor(color);
        speed = new Point(10 - random(20), 10 - random(20));
//        speed = new Point(10, 30);        
        int range = random(MaxRange);
        size = new Dimension(range, range);

    }

    public Dimension getSize() {
        return size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Color getColor() {
        return color;
    }

    public Point getLocation() {
        return location;
    }

    public Point getSpeed() {
        return speed;
    }

    public void setSpeed(Point speed) {
        this.speed = speed;
    }

    protected void paint(Graphics2D g2d) {

        Point p = getLocation();
        if (p != null) {
            g2d.setColor(getColor());
            Dimension size = getSize();
            g2d.fillOval(p.x, p.y, size.width, size.height);
        }

    }
    
    public static int random(int maxRange) {
        return (int) Math.round((Math.random() * maxRange));
    }
}
