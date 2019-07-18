package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    
    private Worm worm;
    private Apple apple;
    
    private Updatable updatable;
    private Random random = new Random();

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
    
        this.worm = new Worm(width / 2, height / 2, Direction.DOWN);
        this.apple = createApple();
        
        addActionListener(this);
        setInitialDelay(2000);

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
    
        worm.move();
        if (worm.runsInto(apple)) {
            worm.grow();
            setApple(createApple());
        }
        if (worm.runsIntoItself() | isWormOutOfBounds()) {
            continues = false;
        }
    
        updatable.update();
        setDelay(1000 / worm.getLength());
    }
    
    private boolean isWormOutOfBounds() {
        int firstX = worm.getFirst().getX();
        int firstY = worm.getFirst().getY();
        if (firstX < 0 || firstX >= width || firstY < 0 || firstY >= height) {
            return true;
        }
        return false;
    }
    
    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    private Apple createApple() {
        Apple newApple;
        do {
            newApple = new Apple(random.nextInt(width), random.nextInt(height));
        } while (worm.runsInto(newApple));
        return newApple;
    }
    
    public Worm getWorm() {
        return worm;
    }
    
    public void setWorm(Worm worm) {
        this.worm = worm;
    }
    
    public Apple getApple() {
        return apple;
    }
    
    public void setApple(Apple apple) {
        this.apple = apple;
    }
}
