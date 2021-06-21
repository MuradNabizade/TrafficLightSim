package com.muradn;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
       TLS tls=new TLS();
       tls.Sim();

    }
}


class TLS extends JComponent{
    final TextField tf=new TextField(3);
    Rectangles light = new Rectangles();


    public static JButton next = new JButton("Next");
    public void Sim() {


        // Creating a new frame using JFrame=
        JFrame frame = new JFrame("Traffic Light Simulator");
        JPanel panel = new JPanel();

        JLabel label = new JLabel("");
        Rectangles rects = new Rectangles();

        // Creating two buttons
        next.setBounds(150,400,95,30);
        buttonListener l = new buttonListener();
        next.addActionListener(l);


        // Adding the created objects
        // to the panel

        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 600);
        frame.add(next);

        frame.add(panel,BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0,1));

        frame.add(tf);
        frame.add(rects);
        frame.add(light);

        frame.setResizable(false);
        frame.setVisible(true);

    }

    class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            light.changeColor();
        }
    }


}


 class Rectangles extends JComponent {
     private BufferedImage bi;
     Color go = Color.gray;
     Color caution = Color.gray;
     Color stop = Color.gray;

     String activeLight="red";

     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g5d = (Graphics2D) g;//Stick under Rectangle

        Graphics2D g4d = (Graphics2D) g;//Yellow
        Graphics2D g3d = (Graphics2D) g;//Green
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D g1d = (Graphics2D) g;//Red


        try {
            bi = ImageIO.read(new File("/Users/muradnabizade/Desktop/road3.png"));//Write path of your image here
        } catch (IOException ex) {

        }
        Graphics g2 = g.create();
        g2.drawImage(bi, 0, 0, getWidth(), getHeight(), null);
        g2.dispose();

        g2d.setColor(Color.yellow);
        g2d.fill3DRect(150, 195, 40, 100,true);

        g1d.setColor(stop);
        g1d.fillOval(157,203,25,25);


        g3d.setColor(caution);
        g3d.fillOval(157,233,25,25);

        g4d.setColor(go);
        g4d.fillOval(157,263,25,25);

        g5d.setColor(new Color(31, 21, 1));
        g5d.fill3DRect(168, 295, 5, 90,true);


    }

    public void changeColor(){
         go=Color.gray;
         caution=Color.gray;
         stop=Color.gray;
         if(activeLight.equals("red")){
             activeLight="green";
             go=Color.green;
         }
         else if(activeLight.equals("green")){
             activeLight="yellow";
             caution=new Color(153,153,0);
         }
         else{
             activeLight="red";
             stop=Color.red;
         }
         repaint();
    }

}







