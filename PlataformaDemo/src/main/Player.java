package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {

    private float x, y;
    private float speed = 3f;
    private Animation animation;
    private int playerAction = Animation.WALK_DOWN; // dirección inicial

    private boolean left, right, up, down;

    public Player(float x, float y) {
        this.x = x;
        this.y = y;
        animation = new Animation(); // sin parámetros
    }

    public void update() {
        move();
        updateAnimation();
        animation.update(playerAction);
    }

    private void move() {
        float dx = 0, dy = 0;

        if (left)  dx -= speed;
        if (right) dx += speed;
        if (up)    dy -= speed;
        if (down)  dy += speed;

        x += dx;
        y += dy;
    }

    private void updateAnimation() {
        int newAction = playerAction;

        boolean moving = left || right || up || down;

        if (!moving) {
        // Quedarse en el primer frame de la dirección actual, sin animar
            animation.resetAnimation();
            return; // no cambia acción ni avanza frames
    }

        if (right)     newAction = Animation.WALK_RIGHT;
        else if (left) newAction = Animation.WALK_LEFT;
        else if (down) newAction = Animation.WALK_DOWN;
        else if (up)   newAction = Animation.WALK_UP;

        if (newAction != playerAction) {
            playerAction = newAction;
            animation.resetAnimation();
    }
}

    public void render(Graphics g) {
        BufferedImage frame = animation.getCurrentFrame(playerAction);
        g.drawImage(frame, (int) x, (int) y, 60, 100, null); // más pequeño en pantalla
    }

    public void setLeft(boolean v)  { left = v; }
    public void setRight(boolean v) { right = v; }
    public void setUp(boolean v)    { up = v; }
    public void setDown(boolean v)  { down = v; }
}