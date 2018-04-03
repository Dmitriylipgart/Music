package com.lipgart;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel implements ControllerEventListener {



    @Override
    public void controlChange(ShortMessage event) {
        repaint();
    }

    public void paintComponent(Graphics g){

            Graphics2D g2 = (Graphics2D) g;
            g.setColor(setRandomColor());
            g.fillRect(0, 0, 300, 300);

            int height = (int)((Math.random() * 120) + 10);
            int width = (int)((Math.random() * 120) + 10);
            int x = (int)((Math.random() * 40) + 10);
            int y = (int)((Math.random() * 40) + 10);


            g.setColor(setRandomColor());
            g.fillOval(x, y, width, height);



    }

    public Color setRandomColor(){
        int r = (int) (Math.random() * 250);
        int gr = (int) (Math.random() * 250);
        int b = (int)(Math.random() * 250);

        return new Color(r, gr, b);
    }
}


