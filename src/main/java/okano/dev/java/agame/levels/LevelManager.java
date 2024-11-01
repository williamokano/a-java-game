package okano.dev.java.agame.levels;

import okano.dev.java.agame.main.Game;
import okano.dev.java.agame.utilz.LoadSave;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LevelManager {
    private Game game;
    private BufferedImage levelSprite;

    public LevelManager(Game game) {
        this.game = game;
        this.levelSprite = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
    }

    public void draw(Graphics g) {
        g.drawImage(levelSprite, 0, 0, null);
    }

    public void update() {

    }
}
