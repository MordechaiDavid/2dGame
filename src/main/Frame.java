package main;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(new GameScene());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}