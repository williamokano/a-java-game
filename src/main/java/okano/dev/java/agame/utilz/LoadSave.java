package okano.dev.java.agame.utilz;

import okano.dev.java.agame.main.Game;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {

    public static final String PLAYER_ATLAS = "player_sprites.png";
    public static final String LEVEL_ATLAS = "outside_sprites.png";
    public static final String LEVEL_ONE_DATA = "level_one_data.png";

    public static BufferedImage getSpriteAtlas(String filename) {
        BufferedImage image;

        try (InputStream is = LoadSave.class.getResourceAsStream("/" + filename)) {
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

        return image;
    }

    public static int[][] getLevelData() {
        int[][] levelData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];

        BufferedImage image = getSpriteAtlas(LEVEL_ONE_DATA);

        for (int row = 0; row < image.getHeight(); row++) {
            for (int col = 0; col < image.getWidth(); col++) {
                Color color = new Color(image.getRGB(col, row));
                int value = color.getRed();
                if (value >= 48) {
                    value = 0;
                }
                levelData[row][col] = value;
            }
        }

        return levelData;
    }
}
