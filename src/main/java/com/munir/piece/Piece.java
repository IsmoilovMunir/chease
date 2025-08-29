package com.munir.piece;

import com.munir.Color;
import com.munir.Coordinates;

abstract public class Piece {
    public final Color color;
    public Coordinates coordinate;

    public Piece(Color color, Coordinates coordinate) {
        this.color = color;
        this.coordinate = coordinate;
    }
}
