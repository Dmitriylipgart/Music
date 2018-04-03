package com.lipgart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui {

    Music music;


    public void start() {


        JFrame frame = new JFrame();
        JPanel panel = new DrawPanel();
        JButton button = new JButton("Start");

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        music = new Music((DrawPanel) panel);

        button.addActionListener(new buttonStart());

        frame.setSize(300, 300);
        frame.setVisible(true);

    }

    class buttonStart implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            music.play();
        }
    }



}
