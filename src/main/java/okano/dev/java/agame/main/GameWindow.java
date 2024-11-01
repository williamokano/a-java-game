package okano.dev.java.agame.main;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

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
        jFrame.setTitle("My Awesome Game from a Platformer tutorial by Kaarin Gaming");
        jFrame.setResizable(false);
        jFrame.setVisible(true);

        jFrame.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                gamePanel.getGame().windowFocusLost();
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {

            }
        });
    }
}
