package com.learn.thinking.enumerated.basic;

public enum Coin {
    PENNY(1), NICKEL(5), DIME(10), QUARTER(25);
    private int cents;

    private Coin(int cents) {
        this.cents = cents;
    }

    public int getCents() {
        return cents;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cents);
        stringBuilder.append(" cent");
        if(cents > 1) {
            stringBuilder.append("s");
        }
        return stringBuilder.toString();
    }
}
