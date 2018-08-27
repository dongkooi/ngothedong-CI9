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

    int enemySpawnCount;

    ArrayList<PlayerBullet> bullets;
    ArrayList<Enemy> enemies;


    BufferedImage backBuffer;
    Graphics backBufferGraphic;
    Random random;
    Player player;
    InputManager inputManager;


    public GameCanvas() {
        random = new Random();
        inputManager = new InputManager();
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        player = new Player(268, 660);
        player.bullets = this.bullets;
        player.inputManager = inputManager;

        background = ImageUtil.load("images/background/background.png");

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

    }


    void render() {
        backBufferGraphic.drawImage(background, 0, 0, null);
        player.render(backBufferGraphic);
        for (PlayerBullet b : bullets) {
            b.render(backBufferGraphic);
        }
        for (Enemy e : enemies) {
            e.render(backBufferGraphic);

        }
        this.repaint();
    }


}
