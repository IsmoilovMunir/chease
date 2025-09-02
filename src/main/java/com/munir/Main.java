package com.munir;

import com.munir.board.Board;
import com.munir.board.BoardConsoleRenderer;
import com.munir.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPositions();
        Board board = new BoardFactory().fromFEN("3k4/8/8/b7/8/8/2PK4/6N1 w - - 0 1");
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