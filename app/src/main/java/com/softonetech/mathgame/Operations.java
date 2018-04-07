package com.softonetech.mathgame;

import java.util.Random;

public class Operations {

    Random RandomGenerator = new Random();

    private String[] Operators;

    public String[] getOperators() {
        return Operators;
    }

    private void setOperators(String[] operators) {
        Operators = operators;
    }
}
