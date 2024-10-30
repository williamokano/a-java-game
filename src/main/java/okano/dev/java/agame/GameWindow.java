package okano.dev.java.agame;

import javax.swing.*;

public class GameWindow {
    private JFrame jFrame;
    public GameWindow() {
        jFrame = new JFrame();

        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
