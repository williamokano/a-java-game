package okano.dev.java.agame.levels;

import okano.dev.java.agame.main.Game;
import okano.dev.java.agame.utilz.LoadSave;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class LevelManager {
    private Game game;
    private BufferedImage[] levelSprite;

    public LevelManager(Game game) {
        this.game = game;
        importOutsideSprites();
    }

    private void importOutsideSprites() {
        levelSprite = new BufferedImage[48];
        BufferedImage img = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 12; col++) {
                int index = row * 12 + col;
                levelSprite[index] = img.getSubimage(col * 32, row * 32, 32, 32);
            }
        }
    }

    public void draw(Graphics g) {
        g.drawImage(levelSprite[2], 0, 0, null);
    }

    public void update() {

    }
}
