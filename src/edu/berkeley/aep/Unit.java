package edu.berkeley.aep;

// Understands how to convert between units
public enum Unit {
    FEET(12, UnitTypes.LENGTH, 0),
    INCHES(1, UnitTypes.LENGTH, 0),
    YARDS(12 * 3, UnitTypes.LENGTH, 0),
    MILES(1760 * 12 * 3, UnitTypes.LENGTH, 0),
    TSP(1, UnitTypes.VOLUME, 0),
    TBSP(3, UnitTypes.VOLUME, 0),
    OZ(6, UnitTypes.VOLUME, 0),
    CUP(48, UnitTypes.VOLUME, 0),
    CELSIUS(9, UnitTypes.TEMPERATURE, 0),
    FAHRENHEIT(5, UnitTypes.TEMPERATURE, -32);

    private final int inBaseUnit;
    private final UnitTypes type;
    private final int offset;

    private enum UnitTypes { VOLUME, LENGTH, TEMPERATURE }

    Unit(int inBaseUnit, UnitTypes type, int offset) {
        this.inBaseUnit = inBaseUnit;
        this.type = type;
        this.offset = offset;
    }

    public int convert(int amount, Unit unit) {
        if (type != unit.type) {
            throw new IllegalArgumentException("Can't compare a " + this + " to a " + unit);
        }
        return ((amount + unit.offset) * unit.inBaseUnit / inBaseUnit) - offset;
    }
}
