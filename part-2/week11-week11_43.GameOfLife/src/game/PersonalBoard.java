package game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {
    
    public PersonalBoard(int width, int height) {
        super(width, height);
    }
    
    @Override
    public void initiateRandomCells(double v) {
        Random random = new Random();
        boolean[][] board = getBoard();
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                double chance = random.nextDouble();
                if (chance < v) {
                    board[i][j] = true;
                } else {
                    board[i][j] = false;
                }
            }
        }
    }
    
    @Override
    public boolean isAlive(int x, int y) {
        if ((x >= 0 && x < getWidth()) && (y >= 0 && y < getHeight())) {
            return getBoard()[x][y];
        }
        return false;
    }
    
    @Override
    public void turnToLiving(int x, int y) {
        if ((x >= 0 && x < getWidth()) && (y >= 0 && y < getHeight())) {
            if (x >= 0 && x < getWidth()) {
                if (y >= 0 && y < getHeight()) {
                    boolean[][] board = getBoard();
                    board[x][y] = true;
                }
            }
        }
    }
    
    @Override
    public void turnToDead(int x, int y) {
        if ((x >= 0 && x < getWidth()) && (y >= 0 && y < getHeight())) {
            boolean[][] board = getBoard();
            board[x][y] = false;
        }
    }
    
    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        boolean[][] board = getBoard();
        
        int count = 0;
        
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (!(i == x && j == y)) {
                    if (isWithinRange(i, j)) {
                        if (board[i][j]) count++;
                    }
                }
            }
        }
        return count;
    }
    
    /* This method is used by getNumberOfLivingNeighbours(). It checks if
     * the parameters are not out of range of the indices of the array */
    private boolean isWithinRange(int x, int y) {
        int width = getWidth();
        int height = getHeight();
        if (x >= 0 && y >= 0) {
            if (x < width && y < height) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void manageCell(int x, int y, int neighbors) {
        boolean[][] board = getBoard();
        if (board[x][y]) {
            if (neighbors < 2 || neighbors > 3) board[x][y] = false;
        } else {
            if (neighbors == 3) board[x][y] = true;
        }
    }
}
