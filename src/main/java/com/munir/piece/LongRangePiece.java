package com.munir.piece;

import com.munir.Board;
import com.munir.BoardUtils;
import com.munir.Color;
import com.munir.Coordinates;

import java.util.List;

public abstract class LongRangePiece extends Piece {
    public LongRangePiece(Color color, Coordinates coordinate) {
        super(color, coordinate);
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean result = super.isSquareAvailableForMove(coordinates, board);
        if (result) {
            return isSquareAvailableForAttack(coordinates, board);
        } else {
            return false;
        }
    }

    @Override
    protected boolean isSquareAvailableForAttack(Coordinates coordinates, Board board) {
        List<Coordinates> coordinatesBetween;
        if (this.coordinate.file == coordinates.file) {
            coordinatesBetween = BoardUtils.getVerticalCoordinatesBetween(this.coordinate, coordinates);
        } else if (this.coordinate.rank.equals(coordinates.rank)) {
            coordinatesBetween = BoardUtils.getHorizontalCoordinatesBetween(this.coordinate, coordinates);

        } else {
            coordinatesBetween = BoardUtils.getDiagonalCoordinatesBetween(this.coordinate, coordinates);
        }
        //2. check that square is free
        for (Coordinates c : coordinatesBetween) {
            if (!board.isSquareEmpty(c)) {
                return false;
            }
        }
        return true;
    }
}
