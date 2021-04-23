package edu.berkeley.aep;

public class Reverser {
    private final String toReverse;

    public Reverser(String toReverse) {
        this.toReverse = toReverse;
    }

    public String reverse() {
        if (toReverse.length() < 2)
            return toReverse;
        return new Reverser(toReverse.substring(1)).reverse() + toReverse.charAt(0);
    }
}
