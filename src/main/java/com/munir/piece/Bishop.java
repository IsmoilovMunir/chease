package com.munir.piece;

import com.munir.Color;
import com.munir.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends LongRangePiece {
    public Bishop(Color color, Coordinates coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        //bottom - left to top-right
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i, i));
        }
        //top- left to bottom - tight
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i, -i));
        }
        return result;
    }
}
