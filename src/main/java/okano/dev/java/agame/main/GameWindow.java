package okano.dev.java.agame.main;

import javax.swing.*;

public class GameWindow {

    private JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {
        jFrame = new JFrame();

//        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the gamePanel and make it adjust for it size
        jFrame.add(gamePanel);
        jFrame.pack();

        // Center window
        jFrame.setLocationRelativeTo(null);

        // Show... but must be last
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
}
