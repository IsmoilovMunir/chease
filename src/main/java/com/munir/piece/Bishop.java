package com.munir.piece;

import com.munir.Color;
import com.munir.Coordinates;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {
    public Bishop(Color color, Coordinates coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return Set.of();
    }


}
