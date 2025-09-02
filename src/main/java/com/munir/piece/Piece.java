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

    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        return board.isSquareEmpty(coordinates) || board.getPiece(coordinates).color != color;
    }

    protected abstract Set<CoordinatesShift> getPieceMoves();

    protected Set<CoordinatesShift> getPieceAttacks() {
        return getPieceMoves();
    }

    public Set<Coordinates> getAttackedSquares(Board board) {
        Set<CoordinatesShift> pieceAttacks = getPieceAttacks();
        Set<Coordinates> result = new HashSet<>();
        for (CoordinatesShift pieceAttack : pieceAttacks) {
            if (coordinate.canShift(pieceAttack)) {
                Coordinates shiftedCoordinates = coordinate.shift(pieceAttack);
                if (isSquareAvailableForAttack(shiftedCoordinates, board)) {
                    result.add(shiftedCoordinates);
                }
            }
        }
        return result;
    }

    protected boolean isSquareAvailableForAttack(Coordinates coordinates, Board board) {
        return true;
    }
}
