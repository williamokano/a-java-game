package okano.dev.java.agame.inputs;

import okano.dev.java.agame.main.GamePanel;
import okano.dev.java.agame.utilz.Constants;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> gamePanel.setDirection(Constants.Directions.UP);
            case KeyEvent.VK_S -> gamePanel.setDirection(Constants.Directions.DOWN);
            case KeyEvent.VK_A -> gamePanel.setDirection(Constants.Directions.LEFT);
            case KeyEvent.VK_D -> gamePanel.setDirection(Constants.Directions.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W,
                 KeyEvent.VK_S,
                 KeyEvent.VK_A,
                 KeyEvent.VK_D -> gamePanel.setMoving(false);
        }
    }
}
