package okano.dev.java.agame.main;

import okano.dev.java.agame.inputs.KeyboardInputs;
import okano.dev.java.agame.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final MouseInputs mouseInputs;
    private int xDelta = 100;
    private int yDelta = 100;
    private int frames = 0;
    private long lastCheck = 0;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
        this.repaint();
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
        this.repaint();
    }

    public void setRectPos(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(xDelta, yDelta, 200, 50);
        this.frames++;
        if (System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + this.frames);
            this.frames = 0;
        }

        this.repaint();
    }
}
