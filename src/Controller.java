import java.awt.event.*;

public class Controller implements KeyListener {
    private GamePanel game;
    private char direction = 'R';

    public Controller(GamePanel game) {
        this.game = game;
    }


    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (game.getPlayer().isAlive()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (this.direction != 'R') {
                        this.direction = 'L';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (this.direction != 'D') {
                        this.direction = 'U';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (this.direction != 'L') {
                        this.direction = 'R';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (this.direction != 'U') {
                        this.direction = 'D';
                    }
                    break;
            }
        } else {
            game.start();
        }
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void keyReleased(KeyEvent e) {

    }
}