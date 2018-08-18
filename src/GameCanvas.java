import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class GameCanvas extends JPanel {
    Image background;

//    int playerX = 268;
//    int playerY = 660;

    int count;
    int enemySpawnCount;

    ArrayList<PlayerBullet> bullets;
    ArrayList<Enemy> enemies;


    boolean shootlock = false;

    BufferedImage backBuffer;
    Graphics backBufferGraphic;
    Random random;
    Player player;
    InputManager inputManager;


    public GameCanvas() {
        random = new Random();
        inputManager = new InputManager();
        bullets = new ArrayList<>();
        PlayerBullet b1 = new PlayerBullet(300, 700);
//        b1.playerX = 300;
//        b1.playerY = 700;
//
        PlayerBullet b2 = new PlayerBullet(600, 600);
//        b2.playerX = 300;
//        b2.playerY = 600;

        enemies = new ArrayList<>();
//        Enemy e1 = new Enemy();
//        e1.playerX = 150;
//        e1.playerY = 200;
//
//        Enemy e2 = new Enemy();
//        e2.playerX = 300;
//        e2.playerY = 200;
//
//        Enemy e3 = new Enemy();
//        e3.playerX = 450;
//        e3.playerY = 200;

        player = new Player(268, 660);
        player.inputManager = inputManager;
        background = ImageUtil.load("images/background/background.png");

//        b1.image = ImageUtil.load("images/bullet/player/mb69bullet1.png");
//        b2.image = ImageUtil.load("images/bullet/player/mb69bullet1.png");
//        e1.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
//        e2.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
//        e3.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
//
//        bullets.add(b1);
//        bullets.add(b2);
//        enemies.add(e1);
//        enemies.add(e2);
//        enemies.add(e3);

        backBuffer = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphic = backBuffer.getGraphics();
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(backBuffer, 0, 0, null);
    }




    void run() {
        player.run();
        for (PlayerBullet b : bullets) {
            b.run();
        }
        for (Enemy e : enemies) {
            e.run();
        }

        enemySpawnCount++;
        if (enemySpawnCount >= 60) {
            enemySpawnCount = 0;
            int posX = random.nextInt(600);
            Enemy enemy = new Enemy(posX, 0);
            enemies.add(enemy);
        }


        if (inputManager.xPressed && !shootlock) {
            PlayerBullet newb = new PlayerBullet(player.x, player.y);
//            newb.x = playerX;
//            newb.y = playerY;
//            try {
//                newb.image = ImageIO.read(new File("images/bullet/player/mb69bullet1.png"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            bullets.add(newb);
            shootlock = true;

        }
        if (shootlock) {
            count++;
            if (count > 15) {
                shootlock = false;
                count = 0;
            }
        }

    }


    void render() {
        backBufferGraphic.drawImage(background, 0, 0, null);
//        backBufferGraphic.drawImage(player.image, player.x, player.y, null);
        player.render(backBufferGraphic);
        for (PlayerBullet b : bullets) {
//            backBufferGraphic.drawImage(b.image, b.x, b.y, null);
            b.render(backBufferGraphic);
        }
        for (Enemy e : enemies) {
//            backBufferGraphic.drawImage(e.image, e.x, e.y, null);
            e.render(backBufferGraphic);

        }
        this.repaint();
    }


}
