package okano.dev.java.agame.main;

import okano.dev.java.agame.inputs.KeyboardInputs;
import okano.dev.java.agame.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    private final MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;

    private float xDir = 0.03f;
    private float yDir = 0.03f;
    private Color color = new Color(150, 20, 30);
    private Random random;

    private int frames = 0;
    private long lastCheck = 0;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        random = new Random();

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

        updateRectangle();

        g.setColor(this.color);
        g.fillRect((int)xDelta, (int)yDelta, 200, 50);
        this.frames++;
        if (System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + this.frames);
            this.frames = 0;
        }

        this.repaint();
    }

    private void updateRectangle() {
        xDelta += xDir;

        if (xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            this.color = getRandomColor();
        }

        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            this.color = getRandomColor();
        }
    }

    private Color getRandomColor() {
        int r = this.random.nextInt(255);
        int g = this.random.nextInt(255);
        int b = this.random.nextInt(255);

        return new Color(r, g, b);
    }
}
