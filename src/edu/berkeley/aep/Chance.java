package edu.berkeley.aep;

// Understands the likelihood of something happening
public class Chance implements Bestable<Chance> {
    private final double probability;

    public Chance(double probability) {
        this.probability = probability;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Chance)) return false;
        Chance otherChance = (Chance) other;
        return otherChance.probability == this.probability;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(probability);
    }

    @Override
    public boolean betterThan(Chance other) {
        return probability > other.probability;
    }
}
