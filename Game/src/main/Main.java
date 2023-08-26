package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //creates new window
        window.setResizable(false); //cannot resize window
        window.setTitle("2D Adventure");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack(); //let's us see the window

        window.setLocationRelativeTo(null); //window created at center of screen
        window.setVisible(true); //allows us to see the window

        gamePanel.startGameThread();

    }
}
