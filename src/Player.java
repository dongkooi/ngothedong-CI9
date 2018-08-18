import javax.imageio.ImageIO;
import java.awt.*;

public class Player {
    int x;
    int y;
    Image image;
    InputManager inputManager;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ImageUtil.load("images/player/MB-69/player1.png");
    }

    // Method
    void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);
    }

    void run() {
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
    }
}
