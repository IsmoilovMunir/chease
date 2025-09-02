package com.munir.piece;

import com.munir.Color;
import com.munir.Coordinates;

import java.util.Set;

public class Queen extends LongRangePiece implements IBishop, IRook {
    public Queen(Color color, Coordinates coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> moves = getBishopMoves();
        moves.addAll(getRookMoves());
        return moves;
    }
}
