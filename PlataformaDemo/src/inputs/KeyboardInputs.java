/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inputs;

import main.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInputs extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tecla presionada: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Tecla liberada: " + KeyEvent.getKeyText(e.getKeyCode()));
    }
}
