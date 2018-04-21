package com.softonetech.mathgame;

import java.util.Random;

public class CustomRandom {

    private int RandomValue;
    private int MinValue;
    private int MaxValue;

    public int getRandomValue() {
        return RandomValue;
    }

    private void setRandomValue(int randomValue) {
        RandomValue = randomValue;
    }

    public int getMinValue() {
        return MinValue;
    }

    public void setMinValue(int minValue) {
        MinValue = minValue;
    }

    public int getMaxValue() {
        return MaxValue;
    }

    public void setMaxValue(int maxValue) {
        MaxValue = maxValue;
    }

    Random Generator = new Random();

    public int generate() {

        int randomNumber = Generator.nextInt((getMaxValue() - getMinValue()) + 1) + getMinValue();

        setRandomValue(randomNumber);

        return getRandomValue();
    }
}
