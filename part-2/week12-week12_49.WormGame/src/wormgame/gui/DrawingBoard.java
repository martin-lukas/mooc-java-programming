package wormgame.gui;

import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel implements Updatable {
    private WormGame game;
    private int pieceLength;
    
    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.pieceLength = pieceLength;
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Worm worm = game.getWorm();
        graphics.setColor(Color.BLACK);
        for (Piece piece : worm.getPieces()) {
            graphics.fill3DRect(
                    piece.getX() * pieceLength,
                    piece.getY() * pieceLength,
                    pieceLength, pieceLength, true);
        }
        Apple apple = game.getApple();
        graphics.setColor(Color.RED);
        graphics.fillOval(
                apple.getX() * pieceLength,
                apple.getY() * pieceLength,
                pieceLength, pieceLength);
    }
    
    @Override
    public void update() {
        repaint();
    }
}
