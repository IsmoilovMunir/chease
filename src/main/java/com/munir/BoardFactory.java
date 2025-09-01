package com.munir;

import com.munir.piece.Pawn;

public class BoardFactory {
    private PieceFactory pieceFactory = new PieceFactory();
    public Board fromFEN(String fen) {
        //2bqk1nr/1pp2p1p/1n1pb3/8/1N6/3PK3/1PP2P1P/1R1Q1BR1 w k - 0 1
        Board board = new Board();
        String[] parts = fen.split(" ");
        String piecePosition = parts[0];
        String[] fenRows = piecePosition.split("/");
        for (int i = 0; i < fenRows.length; i++) {
            String row = fenRows[i];
            int rank = 8 - i;
            int fileIndex = 0;
            for (int j = 0; j < row.length(); j++) {
                char fenChar = row.charAt(j);

                if (Character.isDigit(fenChar)) {
                    fileIndex += Character.getNumericValue(fenChar);
                } else {
                    File file = File.values()[fileIndex];
                    Coordinates coordinates = new Coordinates(file, rank);
                    board.setPiece(coordinates,pieceFactory.fromFenChar(fenChar, coordinates));
                    fileIndex++;
                }
            }
        }
        return board;
    }
}
