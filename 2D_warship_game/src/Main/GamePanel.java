package Main;

import Background.Background;
import Entity.Player;
import Projectiles.ProjectileManager;

import javax.swing.JPanel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable{

    private final int tilesize = 48;
    private final int maxScreenCol = 28;
    private final int maxScreenRow = 15;
    private final int screenWidth = tilesize * maxScreenCol;
    private final int screenHeight = tilesize * maxScreenRow;

    int FPS = 60;

    Background bg = new Background(this);
    KeyHandler keyh = new KeyHandler(this);
    Thread gameThread;
    Player player = new Player(this, this.keyh);
    ProjectileManager projectiles = new ProjectileManager(this, keyh, player);

    public int getScreenWidth() {
        return this.screenWidth;
    }
    public int getScreenHeight() {
        return this.screenHeight;
    }
    public int getFPS() {
        return this.FPS;
    }
    public int getTilesize(){return this.tilesize;}

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update(){
        player.update();
        projectiles.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        bg.draw(g2);
        player.draw(g2);
        projectiles.draw(g2);
        g2.dispose();
    }

    @Override
    public void run(){
        double updateinterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currenttime;

        while(gameThread!=null){
            currenttime = System.nanoTime();
            delta += (currenttime - lastTime) / updateinterval;
            lastTime = currenttime;
            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }
}
