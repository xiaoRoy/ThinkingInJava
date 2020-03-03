package com.learn.thinking.enumerated.basic;

public class Burrito {

    private final Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public String describe() {
        String result;
        switch (degree) {
            case NOT:
                result = "not spice at all";
                break;
            case MILD:
            case MEDIUM:
                result = "a little hot";
                break;
            case HOT:
            case FLAMING:
            default:
                result = "maybe too hot";
                break;
        }
        return result;
    }
}
