import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    Image background, player;
    public GameCanvas() {
        try {
            background = ImageIO.read(new File("images/background/background.png"));
            player = ImageIO.read(new File("images/player/MB-69/player1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(player, 268, 660, null);
    }
}
