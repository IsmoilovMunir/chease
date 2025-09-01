package com.munir;

import com.munir.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPositions();
        Board board = new BoardFactory().fromFEN("3k4/4r3/p5n1/2N5/R3Q3/8/6B1/P2K4 w HAha - 0 1");
        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
  //      renderer.render(board);
//
//        Piece piece = board.getPiece(new Coordinates(File.G, 8));
//        Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);
//        int a = 123;

        Game game = new Game(board);
        game.gameLoop();
    }
}