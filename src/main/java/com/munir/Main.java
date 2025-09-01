package com.munir;

import com.munir.piece.Piece;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPositions();
        Board board = new BoardFactory().fromFEN("8/6p1/8/5pp1/2n1N1P1/3P4/2P5/8 w HAha - 0 1");
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