package com.munir;

import com.munir.board.Board;

public abstract class GameStateChecker {

    public abstract GameState check (Board board, Color color);
}
