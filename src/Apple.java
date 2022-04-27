import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Apple {
    private int appleX;
    private int appleY;
    private Random rand;
    private ImageIcon appleImg;
    private GamePanel game;

    public Apple(GamePanel game) {
        this.game = game;
        this.appleImg = new ImageIcon("images\\apple.png");
        this.rand = new Random();
        this.appleX = rand.nextInt((Dimensions.GAME_WIDTH / Dimensions.OBJECT_SIZE)) * Dimensions.OBJECT_SIZE;
        this.appleY = rand.nextInt((Dimensions.GAME_HEIGHT / Dimensions.OBJECT_SIZE)) * Dimensions.OBJECT_SIZE;
    }

    public void paint(Graphics graphics) {
        this.appleImg.paintIcon(game, graphics, this.appleX, this.appleY);

    }

    public void appleCheck() {
        if (this.game.getPlayer().getSnakeX()[0] == this.appleX && this.game.getPlayer().getSnakeY()[0] == this.appleY) {
            game.getPlayer().addBody();
            game.getPlayer().addScore();
            newApple();
        }
    }
    public void newApple() {
        boolean freePos = false;
        while (!freePos) {
            freePos = true;
            int tempX = rand.nextInt((Dimensions.GAME_WIDTH / Dimensions.OBJECT_SIZE)) * Dimensions.OBJECT_SIZE;
            int tempY = rand.nextInt((Dimensions.GAME_WIDTH / Dimensions.OBJECT_SIZE)) * Dimensions.OBJECT_SIZE;
            for (int i = 0; i < game.getPlayer().getBodyLength(); i++) {
                if (tempX == game.getPlayer().getSnakeX()[i] && tempY == game.getPlayer().getSnakeY()[i]) {
                    freePos = false;
                    break;
                }
            }
            if (freePos) {
                appleX = tempX;
                appleY = tempY;
            }
        }
    }
}
