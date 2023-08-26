package main;

import Tiles.TileManager;
import entity.Player;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    // Screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3; //scales the tile b/c 16x16 is small compared to resolutions on modern computers
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    int FPS = 60;
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH); //allows this gamePanel to recognize key input
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * updates game such as character position
     * draw the screen with updated information
     */
    @Override //creates a game loop
    public void run() {
        double drawInterval = 1000000000/FPS; //0.016666 seconds
        double nextDrawTime = System.nanoTime() + drawInterval; //System.nanoTime keeps track of the time in nanoseconds

        while(gameThread != null){ //as long as the gameThread exists
            update();
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime); //pauses the game loop until the sleep time is over

                nextDrawTime += drawInterval;
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){
        player.update();
    }

    //method from JPanel
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
