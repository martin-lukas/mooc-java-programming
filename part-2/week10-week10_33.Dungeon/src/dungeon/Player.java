package dungeon;

public class Player extends MovableObject {
    public static final char MARKER = '@';
    private int availableMoves;
    
    public Player(int moves) {
        availableMoves = moves;
        super.x = 0;
        super.y = 0;
    }
    
    public boolean move(int direction, int limitX, int limitY) {
        if (availableMoves > 0) {
            int[] newCoordinates = generateMove(direction);
            
            // If new coordinates don't fit into the dungeon field, try another move
            if (isMovePossible(direction, limitX, limitY)) {
                setCoordinates(newCoordinates);
            }
            return true;
        }
        return false;
    }
    
    public int getMoves() {
        return availableMoves;
    }
    
    public void useMove() {
        availableMoves--;
    }
    
    @Override
    public String toString() {
        return Player.MARKER + " " + x + " " + y;
    }
}
