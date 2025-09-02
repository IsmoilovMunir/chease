package com.munir.piece;

import com.munir.board.Board;
import com.munir.Color;
import com.munir.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Color color, Coordinates coordinate) {
        super(color, coordinate);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        if (color == Color.WHITE) {
            result.add(new CoordinatesShift(0, 1));

            if (coordinate.rank == 2) {
                result.add(new CoordinatesShift(0, 2));
            }
            result.add(new CoordinatesShift(-1, 1));
            result.add(new CoordinatesShift(1, 1));


        } else {
            result.add(new CoordinatesShift(0, -1));
            if (coordinate.rank == 7) {
                result.add(new CoordinatesShift(0, -2));
            }
            result.add(new CoordinatesShift(-1, -1));
            result.add(new CoordinatesShift(1, -1));


        }
        return result;
    }

    @Override
    protected Set<CoordinatesShift> getPieceAttacks() {
        Set<CoordinatesShift> result = new HashSet<>();
        if (color == Color.WHITE) {
            result.add(new CoordinatesShift(-1, 1));
            result.add(new CoordinatesShift(1, 1));
        } else {
            result.add(new CoordinatesShift(-1, -1));
            result.add(new CoordinatesShift(1, -1));
        }
        return result;
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        if (this.coordinate.file == coordinates.file) {
            return board.isSquareEmpty(coordinates);
        } else {
            if (board.isSquareEmpty(coordinates)) {
                return false;
            } else {
                return board.getPiece(coordinates).color != color;
            }
        }
    }
}
