package okano.dev.java.agame.main;

import okano.dev.java.agame.inputs.KeyboardInputs;
import okano.dev.java.agame.inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game) {
        this.game = game;

        MouseInputs mouseInputs = new MouseInputs(this);

        this.setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        setPreferredSize(new Dimension(Game.GAME_WIDTH, Game.GAME_HEIGHT));
        System.out.println("size : " + Game.GAME_WIDTH + " : " + Game.GAME_HEIGHT);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }

    public void updateGame() {

    }

    public Game getGame() {
        return game;
    }
}
