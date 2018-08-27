import java.awt.*;

public class Enemy {
    Vector2D position;
    Image image;

    Enemy(int x, int y) {
        position = new Vector2D(x, y);
        this.image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
    }

    void render(Graphics g) {
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);
    }

    void run() {
        Vector2D velocity = new Vector2D();
        velocity.y += 3;
        this.position.addUp(velocity);
    }
}
