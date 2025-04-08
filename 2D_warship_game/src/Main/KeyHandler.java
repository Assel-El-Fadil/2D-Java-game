package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public boolean up, down, left, right, shoot, held;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 38){
            up = true;
        }
        if(code == 40){
            down = true;
        }
        if(code == 39){
            right = true;
        }
        if(code == 37){
            left = true;
        }
        if(code == 32){
            shoot = true;
            held = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 38){
            up = false;
        }
        if(code == 40){
            down = false;
        }
        if(code == 39){
            right = false;
        }
        if(code == 37){
            left = false;
        }
        if(code == 32){
            held = false;
        }
    }
}
