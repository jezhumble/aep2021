package edu.berkeley.aep;

// Understands how to convert between units
public enum Unit {
    FEET(12, UnitTypes.LENGTH, 0, true),
    INCHES(1, UnitTypes.LENGTH, 0, true),
    YARDS(12 * 3, UnitTypes.LENGTH, 0, true),
    MILES(1760 * 12 * 3, UnitTypes.LENGTH, 0, true),
    TSP(1, UnitTypes.VOLUME, 0, true),
    TBSP(3, UnitTypes.VOLUME, 0, true),
    OZ(6, UnitTypes.VOLUME, 0, true),
    CUP(48, UnitTypes.VOLUME, 0, true),
    CELSIUS(9, UnitTypes.TEMPERATURE, 0, false),
    FAHRENHEIT(5, UnitTypes.TEMPERATURE, -32, false);

    private final int inBaseUnit;
    private final UnitTypes type;
    private final int offset;
    private final boolean isArithmetic;

    public void assertIsArithmetic() {
        if (!isArithmetic) {
            throw new IllegalArgumentException(toString() + " is not arithmetic");
        }
    }

    private enum UnitTypes { VOLUME, LENGTH, TEMPERATURE }

    Unit(int inBaseUnit, UnitTypes type, int offset, boolean isArithmetic) {
        this.inBaseUnit = inBaseUnit;
        this.type = type;
        this.offset = offset;
        this.isArithmetic = isArithmetic;
    }

    public int convert(int amount, Unit unit) {
        if (type != unit.type) {
            throw new IllegalArgumentException("Can't compare a " + this + " to a " + unit);
        }
        return ((amount + unit.offset) * unit.inBaseUnit / inBaseUnit) - offset;
    }
}
