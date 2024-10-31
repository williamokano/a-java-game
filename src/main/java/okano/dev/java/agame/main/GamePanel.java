package okano.dev.java.agame.main;

import okano.dev.java.agame.inputs.KeyboardInputs;
import okano.dev.java.agame.inputs.MouseInputs;
import okano.dev.java.agame.utilz.Constants;

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
    private BufferedImage[][] animations;
    private int animationTick, animationIndex, animationSpeed = 15;

    private int playerAction = Constants.PlayerConstants.IDLE;
    private int playerDir = -1;
    private boolean moving = false;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();

        setPreferredSize(new Dimension(1280, 800));
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];

        for (int row = 0; row < animations.length; row++) {
            for (int column = 0; column < animations[row].length; column++) {
                animations[row][column] = image.getSubimage(column * 64, row * 40, 64, 40);
            }
        }
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

        updateAnimationTick();
        setAnimation();
        updatePos();

        g.drawImage(animations[playerAction][animationIndex], (int) xDelta, (int) yDelta, 256, 160, null);
    }

    private void setAnimation() {
        if (moving) {
            playerAction = Constants.PlayerConstants.RUNNING;
        } else {
            playerAction = Constants.PlayerConstants.IDLE;
        }
    }

    private void updatePos() {
        if (moving) {
            switch (playerDir) {
                case Constants.Directions.LEFT -> xDelta -= 5;
                case Constants.Directions.UP -> yDelta -= 5;
                case Constants.Directions.RIGHT -> xDelta += 5;
                case Constants.Directions.DOWN -> yDelta += 5;
            }
        }
    }

    public void setDirection(int direction) {
        playerDir = direction;
        setMoving(true);
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    private void updateAnimationTick() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationIndex = (animationIndex + 1) % Constants.PlayerConstants.getSpriteAmount(playerAction);
            animationTick = 0;
        }
    }
}
