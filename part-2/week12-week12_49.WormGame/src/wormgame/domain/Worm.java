package wormgame.domain;

import wormgame.Direction;

import java.util.ArrayList;
import java.util.List;

public class Worm {
    private Direction direction;
    private List<Piece> pieces;
    private boolean shouldGrow;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.direction = originalDirection;
        pieces = new ArrayList<Piece>();
        pieces.add(new Piece(originalX, originalY));
        shouldGrow = true;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public int getLength() {
        return pieces.size();
    }
    
    public List<Piece> getPieces() {
        return pieces;
    }
    
    public void move() {
        if (pieces.size() < 3) {
            shouldGrow = true;
        }
        
        addPieceInDirection();
        
        if (!shouldGrow) {
            pieces.remove(0);
        } else {
            shouldGrow = false;
        }
    }
    
    public void grow() {
        shouldGrow = true;
    }
    
    private void addPieceInDirection() {
        int x = getFirst().getX();
        int y = getFirst().getY();
        
        if (direction == Direction.LEFT) {
            pieces.add(new Piece(x - 1, y));
        } else if (direction == Direction.RIGHT) {
            pieces.add(new Piece(x + 1, y));
        } else if (direction == Direction.UP) {
            pieces.add(new Piece(x, y - 1));
        } else {
            pieces.add(new Piece(x, y + 1));
        }
    }
    
    public boolean runsInto(Piece piece) {
        for (Piece wormPiece : pieces) {
            if (wormPiece.getX() == piece.getX() && wormPiece.getY() == piece.getY()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean runsIntoItself() {
        Piece firstPiece = getFirst();
        List<Piece> piecesWithoutFirst = new ArrayList<Piece>(pieces);
        piecesWithoutFirst.remove(firstPiece);
        for (Piece piece : piecesWithoutFirst) {
            if (firstPiece.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }
    
    public Piece getFirst() {
        return pieces.get(pieces.size() - 1);
    }
}
