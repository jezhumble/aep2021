package edu.berkeley.aep;

// Understands how to compare arithmetic amounts in different units
public class ArithmeticQuantity extends ScalarQuantity {

    public ArithmeticQuantity(int amount, Unit unit) {
        super(amount, unit);
        unit.assertIsArithmetic();
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        int sum = unit.convert(other.amount, other.unit) + amount;
        return new ArithmeticQuantity(sum, unit);
    }

}
