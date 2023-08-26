package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); //returns the number of the key that was pressed
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){ // if the user pressed w
            upPressed = true;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){ // if the user pressed s
            downPressed = true;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){ // if the user pressed a
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){ // if the user pressed d
            rightPressed= true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP){ // if the user pressed w
            upPressed = false;
        }
        if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){ // if the user pressed s
            downPressed = false;
        }
        if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT){ // if the user pressed a
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){ // if the user pressed d
            rightPressed= false;
        }
    }
}
