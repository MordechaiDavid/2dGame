package tile;

import main.GameScene;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TileManager {

    GameScene gameScene;
    Tile[] tiles;
    public int[][] mapTileNum;

    public TileManager(GameScene gameScene){
        this.gameScene = gameScene;
        tiles = new Tile[10];
        mapTileNum = new int[gameScene.maxWorldCol][gameScene.maxWorldRow];
        getImages();
        loadMap("src/maps/world01.txt");
    }

    public void getImages(){
        tiles[0] = new Tile();
        tiles[0].image = new ImageIcon("res/tile/grass.png").getImage();

        tiles[1] = new Tile();
        tiles[1].image = new ImageIcon("res/tile/wall.png").getImage();

        tiles[2] = new Tile();
        tiles[2].image = new ImageIcon("res/tile/water.png").getImage();

        tiles[3] = new Tile();
        tiles[3].image = new ImageIcon("res/tile/earth.png").getImage();

        tiles[4] = new Tile();
        tiles[4].image = new ImageIcon("res/tile/tree.png").getImage();

        tiles[5] = new Tile();
        tiles[5].image = new ImageIcon("res/tile/sand.png").getImage();

    }

    public void loadMap(String str){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(str));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int row, col;
        row = col = 0;
        while (row < gameScene.maxWorldRow){
            int num = 0;
            try {
                String line = reader.readLine();
                while (col < gameScene.maxWorldCol){
                    String[] numbers = line.split(" ");
                    num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col >= gameScene.maxWorldCol){
                    col = 0;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D graphics2D){
        int currentWorldRow = 0;
        int currentWorldCol = 0;

        while (currentWorldRow < gameScene.maxWorldRow && currentWorldCol < gameScene.maxWorldCol){
            int tileNum = mapTileNum[currentWorldCol][currentWorldRow];
            int worldXPosition = currentWorldCol * gameScene.tileSize;
            int worldYPosition = currentWorldRow * gameScene.tileSize;
            int screenXPosition = worldXPosition - gameScene.player.worldX + gameScene.player.screenX;
            int screenYPosition = worldYPosition - gameScene.player.worldY + gameScene.player.screenY;

            graphics2D.drawImage(tiles[tileNum].image, screenXPosition, screenYPosition, gameScene.tileSize, gameScene.tileSize, null);
            currentWorldCol++;
            if (currentWorldCol >= gameScene.maxWorldCol){
                currentWorldCol = 0;
                currentWorldRow++;
            }
        }

    }
}



