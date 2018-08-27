import javax.imageio.ImageIO;
import java.awt.*;
import java.util.ArrayList;

public class Player {
    Vector2D position;

    int count;
    Image image;
    InputManager inputManager;
    boolean shootlock = false;
    ArrayList<PlayerBullet> bullets;

    public Player(int x, int y) {
        this.position = new Vector2D(x, y);
        this.image = ImageUtil.load("images/player/MB-69/player1.png");
    }

    // Method
    void render(Graphics g) {
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);
    }

    void run() {
        this.move();
        this.shoot();
    }

    private void move() {
        Vector2D velocity = new Vector2D();
        if (inputManager.rightPressed) {
            velocity.x += 5;
        }
        if (inputManager.leftPressed) {
            velocity.x -= 5;
        }
        if (inputManager.upPressed) {
            velocity.y -= 5;
        }
        if (inputManager.downPressed) {
            velocity.y += 5;
        }
        this.position.addUp(velocity);
    }


    private void shoot() {
        if (inputManager.xPressed && !shootlock) {
            PlayerBullet newb = new PlayerBullet((int) this.position.x, (int) this.position.y);
            this.bullets.add(newb);
            this.shootlock = true;
        }
    }
    //        for (PlayerBullet b : bullets) {
//            b.y -= 5;
//        }
}
