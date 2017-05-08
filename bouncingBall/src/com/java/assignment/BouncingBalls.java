/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.assignment;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BouncingBalls {

    public static void main(String[] args) {
        
        JTextField numberOfCircles = new JTextField();
        JTextField rangeOfCircleSize = new JTextField();
        Object[] message = {
            "Enter number of circles ", numberOfCircles,
            "Enter the range of sizes ", rangeOfCircleSize
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {

            String[] range = rangeOfCircleSize.getText().split("\\-");
            BouncingBalls simpleBalls = new BouncingBalls(Integer.parseInt(numberOfCircles.getText()),
                                              Integer.parseInt(range[0].trim()),
                                              Integer.parseInt(range[1].trim()));
            
        } else {
            System.out.println("Canceled");
            System.exit(0);
        }
        
    }

    public BouncingBalls(final int numberOfCircle, final int minRange, final int maxRange) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Application Title");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
 
                Balls balls = new Balls(numberOfCircle, minRange, maxRange);
                frame.add(balls);
                frame.setSize(400, 400);
                frame.setVisible(true);

                new Thread(new BounceEngine(balls)).start();

            }
        });
    }

}