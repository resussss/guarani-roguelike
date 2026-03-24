package main;

import java.awt.image.BufferedImage;

public class Animation {

    private BufferedImage[][] animations;
    private int aniTick, aniIndex;
    private final int ANI_SPEED = 8;

    private final int FRAME_WIDTH  = 130;
    private final int FRAME_HEIGHT = 200;

    // Cuántos frames tiene cada fila
    private final int[] FRAMES_PER_ACTION = {6, 6, 4, 4};

    public static final int WALK_RIGHT = 0;
    public static final int WALK_LEFT  = 1;
    public static final int WALK_DOWN  = 2;
    public static final int WALK_UP    = 3;

    public Animation(String spriteSheetPath) {
        loadAnimations(spriteSheetPath);
    }

    private void loadAnimations(String path) {
        BufferedImage sheet = LoadSave.GetSpriteAtlas(path);

        int rows = FRAMES_PER_ACTION.length;
        // Inicializamos con el máximo de frames por fila
        animations = new BufferedImage[rows][];

        for (int row = 0; row < rows; row++) {
            int cols = FRAMES_PER_ACTION[row];
            animations[row] = new BufferedImage[cols];
            for (int col = 0; col < cols; col++) {
                animations[row][col] = sheet.getSubimage(
                    col * FRAME_WIDTH,
                    row * FRAME_HEIGHT,
                    FRAME_WIDTH,
                    FRAME_HEIGHT
                );
            }
        }
    }

    public void update(int action) {
        aniTick++;
        if (aniTick >= ANI_SPEED) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= FRAMES_PER_ACTION[action]) {
                aniIndex = 0;
            }
        }
    }

    public BufferedImage getCurrentFrame(int action) {
        return animations[action][aniIndex];
    }

    public void resetAnimation() {
        aniTick = 0;
        aniIndex = 0;
    }
}