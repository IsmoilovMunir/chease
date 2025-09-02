package com.munir;

import com.munir.board.Board;
import com.munir.board.BoardFactory;
import com.munir.board.Move;
import com.munir.piece.King;
import com.munir.piece.Piece;

import java.util.List;
import java.util.Set;

public class CheckmateGameStateChecker extends GameStateChecker {
    @Override
    public GameState check(Board board, Color color) {

        // check if king in check
        // check that thers id no move to prevent this check

        Piece king = board.getPieceByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();
        if (!board.isSquareAttackedByColor(king.coordinate, color.opposite())) {
            return GameState.ONGOING;
        }
        List<Piece> pieces = board.getPieceByColor(color);
        for (Piece piece : pieces) {
            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquares(board);

            for (Coordinates coordinates : availableMoveSquares) {
                Board clone = new BoardFactory().copy(board);
                clone.makeMove(new Move(piece.coordinate, coordinates));
                Piece clonedKing = clone.getPieceByColor(color).stream().filter(p -> p instanceof King).findFirst().get();

                if (!clone.isSquareAttackedByColor(clonedKing.coordinate, color.opposite())) {
                    return GameState.ONGOING;
                }
            }
        }
        if (color == Color.WHITE) {
            return GameState.CHECKMATE_To_WHITE_KING;
        } else {
            return GameState.CHECKMATE_TO_BLACK_KING;
        }

    }
}
