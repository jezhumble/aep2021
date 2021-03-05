package edu.berkeley.aep;

// Find the best out of a set of quantities
public class Bester {
    private final ScalarQuantity[] thingsToCompare;

    public Bester(ScalarQuantity... thingsToCompare) {
        if (thingsToCompare.length < 1) {
            throw new IllegalArgumentException("You must pass in at least one thing");
        }
        this.thingsToCompare = thingsToCompare;
    }

    public ScalarQuantity best() {
        var champion = thingsToCompare[0];
        for (var challenger: thingsToCompare) {
            if (challenger.betterThan(champion)) {
                champion = challenger;
            }
        }
        return champion;
    }
}
