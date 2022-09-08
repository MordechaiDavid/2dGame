package entity;

import entity.Entity;
import main.GameScene;
import main.KeyHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    public GameScene gameScene;
    public KeyHandler keyHandler;

    public Player(GameScene gameScene, KeyHandler keyHandler) {
        this.gameScene = gameScene;
        this.keyHandler = keyHandler;
        getImages();
        setDefaultValues();
    }

    public void setDefaultValues() {
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        direction = "down";
        spriteCounter = 0;
        spriteState = 1;
    }

    public void getImages(){
        up1 = new ImageIcon("res/player/boy_up_1.png").getImage();
        up2 = new ImageIcon("res/player/boy_up_2.png").getImage();
        down1 = new ImageIcon("res/player/boy_down_1.png").getImage();
        down2 = new ImageIcon("res/player/boy_down_2.png").getImage();
        right1 = new ImageIcon("res/player/boy_right_1.png").getImage();
        right2 = new ImageIcon("res/player/boy_right_2.png").getImage();
        left1 = new ImageIcon("res/player/boy_left_1.png").getImage();
        left2 = new ImageIcon("res/player/boy_left_2.png").getImage();

    }

        public void update () {
            if (keyHandler.isRight || keyHandler.isLeft || keyHandler.isDown || keyHandler.isUp) {
                if (keyHandler.isRight) {
                    direction = "right";
                    x += speed;
                } else if (keyHandler.isLeft) {
                    direction = "left";
                    x -= speed;
                } else if (keyHandler.isUp) {
                    direction = "up";
                    y -= speed;
                } else if (keyHandler.isDown) {
                    direction = "down";
                    y += speed;
                }

                spriteCounter++;
                if (spriteCounter >= 13) {
                    System.out.println("gr");
                    if (spriteState == 1)
                        spriteState = 2;
                    else if (spriteState == 2)
                        spriteState = 1;
                    spriteCounter = 0;
                }

            }

        }

        public void draw (Graphics2D graphics2D){
            graphics2D.setColor(Color.white);

            Image image = null;
            switch (direction){
                case "right":
                    if (spriteState == 1)
                        image = right1;
                    else
                        image = right2;
                    break;
                case "left":
                    if (spriteState == 1)
                        image = left1;
                    else
                        image = left2;
                    break;
                case "up":
                    if (spriteState == 1)
                        image = up1;
                    else
                        image = up2;
                    break;
                case "down":
                    if (spriteState == 1)
                        image = down1;
                    else
                        image = down2;
                    break;

            }

            graphics2D.drawImage(image, this.x, this.y, gameScene.tileSize, gameScene.tileSize, null);
        }

}
