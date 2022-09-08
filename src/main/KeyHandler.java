package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean isUp, isDown, isRight, isLeft;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                isUp = true;
                break;
            case KeyEvent.VK_DOWN:
                isDown = true;
                break;
            case KeyEvent.VK_RIGHT:
                isRight = true;
                break;
            case KeyEvent.VK_LEFT:
                isLeft = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                isUp = false;
                break;
            case KeyEvent.VK_DOWN:
                isDown = false;
                break;
            case KeyEvent.VK_RIGHT:
                isRight = false;
                break;
            case KeyEvent.VK_LEFT:
                isLeft = false;
                break;
        }
    }
}
