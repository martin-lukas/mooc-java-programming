package movingfigure;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    
    private Component component;
    private Figure figure;
    
    public KeyboardListener(Component component, Figure figure) {
        this.figure = figure;
        this.component = component;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            figure.move(-5, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            figure.move(5, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            figure.move(0, -5);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            figure.move(0, 5);
        }
        
        component.repaint();
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    
    }
}
