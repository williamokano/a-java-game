package okano.dev.java.agame.main;

import okano.dev.java.agame.inputs.KeyboardInputs;
import okano.dev.java.agame.inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {

    private final MouseInputs mouseInputs;
    private float xDelta = 0;
    private float yDelta = 0;

    private BufferedImage image;
    private BufferedImage subImage;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        importImg();

        setPreferredSize(new Dimension(1280, 800));
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importImg() {
        try (InputStream is = getClass().getResourceAsStream("/player_sprites.png")) {

            if (is == null) {
                throw new RuntimeException("Image not found");
            }

            try {
                image = ImageIO.read(is);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeXDelta(int value) {
        this.xDelta += value;
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.subImage = this.image.getSubimage(1 * 64, 8 * 40, 64, 40);
        g.drawImage(subImage, (int) xDelta, (int) yDelta, 128, 80, null);
    }

    public void setRectPos(int x, int y) {
        xDelta = x;
        yDelta = y;
    }
}
