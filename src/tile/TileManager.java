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
        tiles = new Tile[3];
        mapTileNum = new int[gameScene.maxCol][gameScene.maxRow];
        getImages();
        loadMap("src/maps/map01.txt");
    }

    public void getImages(){
        tiles[0] = new Tile();
        tiles[0].image = new ImageIcon("res/tile/grass.png").getImage();

        tiles[1] = new Tile();
        tiles[1].image = new ImageIcon("res/tile/wall.png").getImage();

        tiles[2] = new Tile();
        tiles[2].image = new ImageIcon("res/tile/water.png").getImage();

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
        while (row < gameScene.maxRow){
            int num = 0;
            try {
                String line = reader.readLine();
                while (col < gameScene.maxCol){
                    String[] numbers = line.split(" ");
                    num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col >= gameScene.maxCol){
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
        int x = 0;
        int y = 0;
        int row = 0;
        int col = 0;
        while (row < gameScene.maxRow){
            int tileNum = mapTileNum[col][row];
            graphics2D.drawImage(tiles[tileNum].image, x, y, gameScene.tileSize, gameScene.tileSize, null);
            x+=gameScene.tileSize;
            col++;
            if (col >= gameScene.maxCol){
                col = 0;
                x = 0;
                y+=gameScene.tileSize;
                row++;
            }
        }

    }
}



