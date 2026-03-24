/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import inputs.KeyboardInputs;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public GamePanel() {
        setFocusable(true);
        addKeyListener(new KeyboardInputs()); // ← sin "Inputs."
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(100, 100, 100, 100);
    }
}