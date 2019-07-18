package dungeon;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Vampire extends MovableObject {
    public static final char MARKER = 'v';
    private Random random = new Random();
    
    public Vampire(int length, int height) {
        int initialX = random.nextInt(length);
        int initialY = random.nextInt(height);
        super.x = initialX;
        super.y = initialY;
    }
    
    public void move(int limitX, int limitY, List<List<Integer>> vampiresCoordinates) {
        int direction = random.nextInt(Dungeon.DIRECTIONS.length + 1);
        int[] newCoordinates = generateMove(direction);
        
        if (isMovePossible(direction, limitX, limitY)) {
            if (!isMoveOverlapping(newCoordinates, vampiresCoordinates)) {
                setCoordinates(newCoordinates);
            }
        }
    }
    
    private boolean isMoveOverlapping(int[] coordinates, List<List<Integer>> vampiresCoordinates) {
        for (List<Integer> vampiresCoordinate : vampiresCoordinates) {
            if (coordinates[0] == vampiresCoordinate.get(0)
                    && coordinates[1] == vampiresCoordinate.get(1)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        return Vampire.MARKER + " " + x + " " + y;
    }
}
