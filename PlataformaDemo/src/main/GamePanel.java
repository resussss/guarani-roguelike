package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;
    private final int FPS = 60;
    private final Player player;
    private final BufferedImage mapBackground;

    public GamePanel() {
        mapBackground = LoadSave.GetSpriteAtlas("map_bg.png");
        player = new Player(200, 300);
        setFocusable(true);
        addKeyListener(new KeyboardInputs(player));
    }

    public void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1_000_000_000.0 / FPS;
        long lastTime = System.nanoTime();
        while (true) {
            long now = System.nanoTime();
            if (now - lastTime >= timePerFrame) {
                update();
                repaint();
                lastTime = now;
            }
        }
    }

    private void update() {
        player.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Primero el fondo, luego el jugador encima
        if (mapBackground != null)
            g.drawImage(mapBackground, 0, 0, getWidth(), getHeight(), null);
        player.render(g);
    }
}