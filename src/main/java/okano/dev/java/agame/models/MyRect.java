package okano.dev.java.agame.models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MyRect {
    int x, y, w, h;
    int xDir = 1, yDir = 1;
    Color color;
    Random random = new Random();

    public MyRect(int x, int y) {
        this.x = x;
        this.y = y;
        w = random.nextInt(50);
        h = w;
        color = newColor();
    }

    public void updateRect() {
        this.x += xDir;
        this.y += yDir;

        if ((x + w) > 400 || x < 0) {
            xDir *= -1;
            color = newColor();
        }

        if ((y + h) > 400 || y < 0) {
            yDir *= -1;
            color = newColor();
        }
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(x, y, w, h);
    }

    private Color newColor() {
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}
