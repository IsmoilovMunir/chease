package com.munir;

import com.munir.board.Board;
import com.munir.board.BoardConsoleRenderer;
import com.munir.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
//        Board board = new Board();
//        board.setupDefaultPiecesPositions();
        Board board = new BoardFactory().fromFEN(//"8/8/8/8/k5p1/5pP1/3pPP2/1K5N w - - 0 1");
                "4k3/4P3/8/4K3/8/8/8/8 w - - 0 1");
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