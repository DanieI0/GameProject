import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    private Snake player;
    private Apple apple;
    private ImageIcon background;
    private Controller controller;
    private Timer timer;

    public GamePanel() {
        this.setPreferredSize(new Dimension(Dimensions.GAME_WIDTH, Dimensions.GAME_HEIGHT));
        this.setBackground(Color.BLACK);
        this.background = new ImageIcon("images\\jungle.png");
        this.setFocusable(true);
        this.controller = new Controller(this);
        this.addKeyListener(controller);
        this.timer = new Timer(180,this);
        start();
    }

    protected void start() {
        controller.setDirection('R');
        this.player = new Snake(this);
        this.apple = new Apple(this);
        timer.start();
    }

    public void gameOver(Graphics graphics) {
        graphics.setColor(Color.RED);
        String over = "GAME OVER";
        String score = "SCORE:  " + this.getPlayer().getScore();
        String reset = "Press any key to restart the game";
        graphics.setFont(new Font("Arial",Font.BOLD,25));
        FontMetrics metrics = getFontMetrics(graphics.getFont());
        graphics.drawString(over, (Dimensions.GAME_WIDTH - metrics.stringWidth(over))/2  , Dimensions.GAME_HEIGHT/4);
        graphics.drawString(score, (Dimensions.GAME_WIDTH - metrics.stringWidth(score))/2, Dimensions.GAME_HEIGHT/3);
        graphics.drawString(reset, (Dimensions.GAME_WIDTH - metrics.stringWidth(score))/50, Dimensions.GAME_HEIGHT/2);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (this.player.isAlive()) {
            background(graphics);
            this.player.paint(graphics);
            this.apple.paint(graphics);
        } else{
            gameOver(graphics);
        }

    }

    public void background(Graphics graphics) {
            this.background.paintIcon(this, graphics, 0, 0);
    }

    public Snake getPlayer() {return this.player;}
    public Controller getController() {return controller;}
    public Timer getTimer() {return timer;}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.player.isAlive()){
            this.player.move();
            this.player.checkCollisions();
            this.apple.appleCheck();
        } else{
            start();
        }
        repaint();
    }
}