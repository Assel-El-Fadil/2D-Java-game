package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyh;

    //constructors
    public Player(GamePanel gp, KeyHandler keyh){
        this.gp = gp;
        this.keyh = keyh;

        setdefault();
        getPlayerImage();
    }
    public Player(GamePanel gp, KeyHandler keyh,int hp, int attack, int vitesse){
        this.gp = gp;
        this.keyh = keyh;
        this.hp = hp;
        this.attack = attack;
        this.vitesse = vitesse;
    }

    public int getx(){return this.x;}
    public int gety(){return this.y;}

    //methods
    public void setdefault(){
        x = gp.getScreenWidth()/2;
        y = gp.getScreenHeight()/2;
        vitesse = 4;
    }

    public void getPlayerImage(){
        try{
            this.ship = ImageIO.read(getClass().getResourceAsStream("/player/playership1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyh.up){
            if(this.y > 0){
                y -= vitesse;;
            }
        }
        if(keyh.down){
            if(this.y < gp.getScreenHeight() - gp.getTilesize()) {
                y += vitesse;
            }
        }
        if(keyh.left){
            if(this.x > 0) {
                x -= vitesse;
            }
        }
        if(keyh.right){
            if(this.x < gp.getScreenWidth() - gp.getTilesize()) {
                x += vitesse;
            }
        }
    }
    public void draw(Graphics2D g2){

        BufferedImage img = ship;
        g2.drawImage(img, x, y, gp.getTilesize(), gp.getTilesize(), null);
    }
}
