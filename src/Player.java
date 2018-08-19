import javax.imageio.ImageIO;
import java.awt.*;
import java.util.ArrayList;

public class Player {
    int x;
    int y;
    int count;
    Image image;
    InputManager inputManager;
    boolean shootlock = false;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ImageUtil.load("images/player/MB-69/player1.png");
    }

    // Method
    void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }

    void run(ArrayList<PlayerBullet> bullets) {
        if (inputManager.rightPressed) {
            this.x += 5;
        }
        if (inputManager.leftPressed) {
            this.x -= 5;
        }
        if (inputManager.upPressed) {
            this.y -= 5;
        }
        if (inputManager.downPressed) {
            this.y += 5;
        }

        if (inputManager.xPressed && !shootlock) {
            PlayerBullet newb = new PlayerBullet(this.x, this.y);
            bullets.add(newb);
            shootlock = true;

        }
        for (PlayerBullet b : bullets) {
            b.y -= 5;
        }
        if (shootlock) {
            count++;
            if (count > 15) {
                shootlock = false;
                count = 0;
            }
        }
    }
}
