package edu.berkeley.aep;

// Understands how to convert between units
public enum Unit {
    FEET(12, UnitTypes.LENGTH),
    INCHES(1, UnitTypes.LENGTH),
    YARDS(12 * 3, UnitTypes.LENGTH),
    MILES(1760 * 12 * 3, UnitTypes.LENGTH),
    TSP(1, UnitTypes.VOLUME),
    TBSP(3, UnitTypes.VOLUME),
    OZ(6, UnitTypes.VOLUME),
    CUP(48, UnitTypes.VOLUME);

    private final int inBaseUnit;
    private final UnitTypes type;

    private enum UnitTypes { VOLUME, LENGTH }

    Unit(int inBaseUnit, UnitTypes type) {
        this.inBaseUnit = inBaseUnit;
        this.type = type;
    }

    public int convert(int amount, Unit unit) {
        if (type != unit.type) {
            throw new IllegalArgumentException("Can't compare a " + this + " to a " + unit);
        }
        return amount * unit.inBaseUnit / inBaseUnit;
    }
}
