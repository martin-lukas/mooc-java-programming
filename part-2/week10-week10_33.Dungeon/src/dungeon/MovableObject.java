package dungeon;

public abstract class MovableObject {
    protected int x;
    protected int y;
    
    public int[] getCoordinates() {
        return new int[]{x, y};
    }
    
    public int[] generateMove(int direction) {
        int newX = x;
        int newY = y;
        if (direction == 0) {
            newY--;
        } else if (direction == 1) {
            newX--;
        } else if (direction == 2) {
            newY++;
        } else if (direction == 3) {
            newX++;
        }
        return new int[]{newX, newY};
    }
    
    public void setCoordinates(int[] newCoordinates) {
        this.x = newCoordinates[0];
        this.y = newCoordinates[1];
    }
    
    public boolean isMovePossible(int direction, int limitX, int limitY) {
        int[] newCoordinates = generateMove(direction);
        int newX = newCoordinates[0];
        int newY = newCoordinates[1];
        
        // If new coordinates don't fit into the dungeon field, try another move
        if ((newX >= 0 && newX < limitX) && (newY >= 0 && newY < limitY)) {
            return true;
        } else {
            return false;
        }
    }
}
