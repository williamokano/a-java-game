package okano.dev.java.agame.main;

import okano.dev.java.agame.entities.Player;

import java.awt.Graphics;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private Player player;

    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    public Game() {
        this.initClasses();

        this.gamePanel = new GamePanel(this);
        this.gameWindow = new GameWindow(this.gamePanel);

        this.gamePanel.requestFocus();
        this.startGameLoop();
    }

    private void initClasses() {
        this.player = new Player(200, 200);
    }

    private void startGameLoop() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1_000_000_000.0 / FPS_SET;
        double timePerUpdate = 1_000_000_000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0; // lag between updates
        double deltaF = 0; // lag between renders

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;

            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            // FPS check
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }

    }

    public void update() {
//        gamePanel.updateGame();
        player.update();
    }

    public void render(Graphics g) {
        player.render(g);
    }

    public Player getPlayer() {
        return player;
    }

    public void windowFocusLost() {
        player.resetDirBooleans();
    }
}
