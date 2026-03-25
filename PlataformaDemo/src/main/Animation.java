package main;

import java.awt.image.BufferedImage;

public class Animation {

    private BufferedImage[][] animations; // [accion][frame]
    private int aniTick, aniIndex;
    private final int ANI_SPEED = 8;
    private final int FRAMES = 4;

    public static final int WALK_DOWN  = 0;
    public static final int WALK_UP    = 1;
    public static final int WALK_RIGHT = 2;
    public static final int WALK_LEFT  = 3;

    private static final String[] ACTION_NAMES = {
        "walk_down", "walk_up", "walk_right", "walk_left"
    };

    public Animation() {
        loadAnimations();
    }

    private void loadAnimations() {
        animations = new BufferedImage[4][FRAMES];
        for (int action = 0; action < 4; action++) {
            for (int frame = 0; frame < FRAMES; frame++) {
                String path = "player/" + ACTION_NAMES[action] + "_" + frame + ".png";
                animations[action][frame] = LoadSave.GetSpriteAtlas(path);
            }
        }
    }

    public void update(int action) {
        aniTick++;
        if (aniTick >= ANI_SPEED) {
            aniTick = 0;
            aniIndex = (aniIndex + 1) % FRAMES;
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