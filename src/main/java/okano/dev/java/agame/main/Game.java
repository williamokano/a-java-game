package okano.dev.java.agame.main;

public class Game {

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game() {
        this.gamePanel = new GamePanel();
        this.gameWindow = new GameWindow(this.gamePanel);

        this.gamePanel.requestFocus();
    }
}
