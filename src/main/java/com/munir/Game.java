package com.munir;

import com.munir.board.Board;
import com.munir.board.BoardConsoleRenderer;
import com.munir.board.Move;

public class Game {
    private final Board board;
    private final BoardConsoleRenderer renderer = new BoardConsoleRenderer();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;
        while (true) {
            //render
            renderer.render(board);
            if (isWhiteToMove) {
                System.out.println("White to move");
            } else {
                System.out.println("Black to move");
            }
            //input
            Move move = InputCoordinates.inputMove(board, isWhiteToMove ? Color.WHITE : Color.BLACK, renderer);
            //make move

            board.makeMove(move);
            //pass move
            isWhiteToMove = !isWhiteToMove;
        }
    }
}
