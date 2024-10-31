package okano.dev.java.agame.main;

import okano.dev.java.agame.inputs.KeyboardInputs;
import okano.dev.java.agame.inputs.MouseInputs;
import okano.dev.java.agame.models.MyRect;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {

    private final MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;

    private float xDir = 1f;
    private float yDir = 1f;
    private Color color = new Color(150, 20, 30);
    private Random random;

    private int frames = 0;
    private long lastCheck = 0;

    private List<MyRect> rects = new ArrayList<>();

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        random = new Random();

        setPreferredSize(new Dimension(400, 400));
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

    public void spawnRect(int x, int y) {
        rects.add(new MyRect(x, y));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MyRect rect : rects) {
            rect.updateRect();
            rect.draw(g);
        }

        updateRectangle();

        g.setColor(this.color);
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);

    }

    private void updateRectangle() {
        xDelta += xDir;

        if ((xDelta + 200) > 400 || xDelta < 0) {
            xDir *= -1;
            this.color = getRandomColor();
        }

        yDelta += yDir;
        if ((yDelta + 50) > 400 || yDelta < 0) {
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
