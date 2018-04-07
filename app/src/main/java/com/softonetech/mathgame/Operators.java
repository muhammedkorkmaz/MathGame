package com.softonetech.mathgame;

public enum Operators {
    Plus("+"),
    Minus("-"),
    Multiplication("x"),
    Division("÷");

    private final String Code;

    Operators(String code) {
        this.Code = code;
    }

    public String getCode() {
        return Code;
    }
}
