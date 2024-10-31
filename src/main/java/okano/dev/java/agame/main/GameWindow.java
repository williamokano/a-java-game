package okano.dev.java.agame.main;

import javax.swing.*;

public class GameWindow {

    private JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {
        jFrame = new JFrame();

        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.add(gamePanel);

        // Center window
        jFrame.setLocationRelativeTo(null);

        // Show... but must be last
        jFrame.setVisible(true);
    }
}
