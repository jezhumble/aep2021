package edu.berkeley.aep;

// Understands how to compare amounts in different units
public class Quantity {
    private final int amount;
    private final Unit unit;

    public Quantity(int amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof Quantity)) return false;
        Quantity otherQuantity = (Quantity) other;
        return amount == unit.convert(otherQuantity.amount, otherQuantity.unit);
    }

    public Quantity add(Quantity other) {
        int sum = unit.convert(other.amount, other.unit) + amount;
        return new Quantity(sum, unit);
    }

    @Override
    public String toString() {
        return amount + " " + unit;
    }
}
