import javax.swing.*;

public class GameFrame extends JFrame {


    public GameFrame(){
        this.add(new GamePanel());
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Snake");
        this.setVisible(true);
    }
}
