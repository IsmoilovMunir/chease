package com.munir.piece;

import com.munir.Color;
import com.munir.Coordinates;

import java.util.Set;

public class King extends Piece {
    public King(Color color, Coordinates coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return Set.of();
    }
}
