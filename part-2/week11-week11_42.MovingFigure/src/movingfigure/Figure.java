package movingfigure;

import java.awt.*;

public abstract class Figure {
    private int x;
    private int y;
    
    public Figure() {}
    
    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public abstract void draw(Graphics graphics);
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
