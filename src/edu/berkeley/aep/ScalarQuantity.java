package edu.berkeley.aep;

// Understands how to compare scalar amounts in different units
public class ScalarQuantity implements Bestable {
    protected final int amount;
    protected final Unit unit;

    public ScalarQuantity(int amount, Unit unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (!(other instanceof ScalarQuantity)) return false;
        ScalarQuantity otherQuantity = (ScalarQuantity) other;
        return amount == unit.convert(otherQuantity.amount, otherQuantity.unit);
    }

    @Override
    public String toString() {
        return amount + " " + unit;
    }

    @Override
    public boolean betterThan(Bestable other) {
        ScalarQuantity otherQuantity = (ScalarQuantity) other;
        return amount > unit.convert(otherQuantity.amount, otherQuantity.unit);
    }
}
