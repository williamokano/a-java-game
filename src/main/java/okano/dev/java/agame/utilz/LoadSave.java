package okano.dev.java.agame.utilz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {

    public static final String PLAYER_ATLAS = "player_sprites.png";
    public static final String LEVEL_ATLAS = "outside_sprites.png";

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
}
