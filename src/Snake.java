import java.awt.*;

public class Snake {
    private final int[] snakeX;
    private final int[] snakeY;
    private int bodyLength;
    private int score;
    private boolean alive;
    private GamePanel game;

    public Snake(GamePanel game) {
        this.game = game;
        this.snakeX = new int[Dimensions.GAME_SIZE];
        this.snakeY = new int[Dimensions.GAME_SIZE];
        this.bodyLength = Dimensions.START_BODY_LENGTH;
        this.score = 0;
        this.alive = true;
    }

    public void paint(Graphics graphics) {
        for (int i = 0; i < this.bodyLength; i++) {
            if (i == 0) {
                graphics.setColor(new Color(232, 219, 65));
                graphics.fillRoundRect(this.snakeX[i], this.snakeY[i], Dimensions.OBJECT_SIZE, Dimensions.OBJECT_SIZE,50,50);
            } else {

                graphics.setColor(new Color(74, 173, 39));
                graphics.fillRoundRect(this.snakeX[i], this.snakeY[i], Dimensions.OBJECT_SIZE, Dimensions.OBJECT_SIZE,50,50);
            }
        }
    }

    public void move() {
        for (int i = this.bodyLength; i > 0; i--) {
            this.snakeX[i] = this.snakeX[i - 1];
            this.snakeY[i] = this.snakeY[i - 1];
        }
        switch(game.getController().getDirection()){
            case 'U' ->  this.snakeY[0] -= Dimensions.OBJECT_SIZE;
            case 'R' ->  this.snakeX[0] += Dimensions.OBJECT_SIZE;
            case 'D' ->  this.snakeY[0] += Dimensions.OBJECT_SIZE;
            case 'L' ->  this.snakeX[0] -= Dimensions.OBJECT_SIZE;
        }
    }

    public void checkCollisions () {
        for (int i = this.bodyLength; i > 0; i--) {
            if (this.snakeX[0] == this.snakeX[i] && this.snakeY[0] == this.snakeY[i]) {
                this.alive = false;
                break;
            }
        }

        if (    this.snakeX[0] < 0
                || this.snakeX[0] > Dimensions.GAME_WIDTH - Dimensions.OBJECT_SIZE
                || this.snakeY[0] < 0
                || this.snakeY[0] > Dimensions.GAME_HEIGHT - Dimensions.OBJECT_SIZE ) {
            this.alive = false;
        }
        if (!this.alive){
            game.getTimer().stop();
        }
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        this.score++;
    }
    public int getBodyLength(){return bodyLength;}
    public void addBody(){this.bodyLength++;}
    public int[] getSnakeX() {
        return snakeX;
    }
    public int[] getSnakeY() {return snakeY;}
    public boolean isAlive () {return alive;}
    }