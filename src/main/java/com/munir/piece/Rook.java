package com.munir.piece;

import com.munir.Color;
import com.munir.Coordinates;

import java.util.Set;

public class Rook extends LongRangePiece implements IRook {
    public Rook(Color color, Coordinates coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return getRookMoves();
    }

}
