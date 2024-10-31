package okano.dev.java.agame.main;

public class Game implements Runnable {

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;

    private final int FPS_SET = 120;
    private final int UPS_SET = 60;

    public Game() {
        this.gamePanel = new GamePanel();
        this.gameWindow = new GameWindow(this.gamePanel);

        this.gamePanel.requestFocus();
        this.startGameLoop();
    }

    private void startGameLoop() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run() {

        double timePerFrame = 1_000_000_000 / (double)FPS_SET;
        long lastFrame = System.nanoTime();
        long now;

        while (true) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {

                gamePanel.repaint();
                lastFrame = System.nanoTime();

            }
        }

    }
}
