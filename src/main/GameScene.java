package main;

import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GameScene extends JPanel {
    public int originalTileSize = 16;
    public int scale = 3;
    public int tileSize = originalTileSize * scale;
    public int maxCol = 16;
    public int maxRow = 12;
    public int screenWidth = tileSize * maxCol;
    public int screenHeight = tileSize * maxRow;
    public GameEngine engine;
    public int FPS = 60;
    public KeyHandler keyHandler = new KeyHandler();
    public Player player = new Player(this, keyHandler);
    public TileManager tileManager = new TileManager(this);

    public GameScene() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        startGameThread();

    }

    public void startGameThread(){
        engine = new GameEngine(this);
        engine.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        tileManager.draw(g2d);
        player.draw(g2d);
        g2d.dispose();

    }

    public void update(){
        player.update();
    }


}