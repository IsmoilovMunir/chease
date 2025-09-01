package com.munir.piece;

import com.munir.Board;
import com.munir.Color;
import com.munir.Coordinates;

import java.util.HashSet;
import java.util.Set;

abstract public class Piece {
    public final Color color;
    public Coordinates coordinate;

    public Piece(Color color, Coordinates coordinate) {
        this.color = color;
        this.coordinate = coordinate;
    }

    public Set<Coordinates> getAvailableMoveSquares(Board board) {
        Set<Coordinates> result = new HashSet<>();
        for (CoordinatesShift shift : getPieceMoves()) {
            if (coordinate.canShift(shift)) {
                Coordinates newCoordinates = coordinate.shift(shift);
                if (isSquareAvailableForMove(newCoordinates, board)) {
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    private boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        return board.isSquareEmpty(coordinates) || board.getPiece(coordinates).color != color;
    }

    protected abstract Set<CoordinatesShift> getPieceMoves();
}
