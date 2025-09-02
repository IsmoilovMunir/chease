package com.munir;

public enum Color {
    BLACK, WHITE;

    public Color opposite() {
        return this == WHITE ? BLACK : WHITE;
    }
}
