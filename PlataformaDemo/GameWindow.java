package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInputs extends KeyAdapter {

    private Player player;

    public KeyboardInputs(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A, KeyEvent.VK_LEFT  -> player.setLeft(true);
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> player.setRight(true);
            case KeyEvent.VK_W, KeyEvent.VK_UP    -> player.setUp(true);
            case KeyEvent.VK_S, KeyEvent.VK_DOWN  -> player.setDown(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A, KeyEvent.VK_LEFT  -> player.setLeft(false);
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> player.setRight(false);
            case KeyEvent.VK_W, KeyEvent.VK_UP    -> player.setUp(false);
            case KeyEvent.VK_S, KeyEvent.VK_DOWN  -> player.setDown(false);
        }
    }
}
}