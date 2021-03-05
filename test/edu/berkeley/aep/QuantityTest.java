package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuantityTest {
    @Test
    public void oneFootShouldEqualTwelveInches() {
        ArithmeticQuantity oneFoot = new ArithmeticQuantity(1, Unit.FEET);
        ArithmeticQuantity twelveInches = new ArithmeticQuantity(12, Unit.INCHES);
        assertEquals(twelveInches, oneFoot);
    }

    @Test
    public void threeFeetShouldEqualOneYard() {
        ArithmeticQuantity threeFeet = new ArithmeticQuantity(3, Unit.FEET);
        ArithmeticQuantity oneYard = new ArithmeticQuantity(1, Unit.YARDS);
        assertEquals(oneYard, threeFeet);
    }
    
    @Test
    public void oneMileShouldEqual1760Feet() {
        ArithmeticQuantity oneMile = new ArithmeticQuantity(1, Unit.MILES);
        ArithmeticQuantity one760Feet = new ArithmeticQuantity(1760, Unit.YARDS);
        assertEquals(oneMile, one760Feet);
    }

    @Test
    public void oneTbspShouldEqualThreeTsp() {
        ArithmeticQuantity oneTbsp = new ArithmeticQuantity(1, Unit.TBSP);
        ArithmeticQuantity threeTsp = new ArithmeticQuantity(3, Unit.TSP);
        assertEquals(oneTbsp, threeTsp);
    }

    @Test
    public void oneOzShouldEqualTwoTbsp() {
        ArithmeticQuantity oneOz = new ArithmeticQuantity(1, Unit.OZ);
        ArithmeticQuantity twoTbsp = new ArithmeticQuantity(2, Unit.TBSP);
        assertEquals(oneOz, twoTbsp);
    }

    @Test
    public void eightOzShouldEqualOneCup() {
        ArithmeticQuantity eightOz = new ArithmeticQuantity(8, Unit.OZ);
        ArithmeticQuantity oneCup = new ArithmeticQuantity(1, Unit.CUP);
        assertEquals(eightOz, oneCup);
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        ArithmeticQuantity fourInches = new ArithmeticQuantity(4, Unit.INCHES);
        ArithmeticQuantity twoInches = new ArithmeticQuantity(2, Unit.INCHES);
        assertEquals(fourInches, twoInches.add(twoInches));
    }

    @Test
    public void twoTbspPlusOneOzShouldEqual12Tsp() {
        ArithmeticQuantity twoTbsp = new ArithmeticQuantity(2, Unit.TBSP);
        ArithmeticQuantity oneOz = new ArithmeticQuantity(1, Unit.OZ);
        assertEquals(new ArithmeticQuantity(12, Unit.TSP), oneOz.add(twoTbsp));
    }

    @Test(expected = IllegalArgumentException.class)
    public void twoInchesPlusTwoTspShouldNotEqualFourInches() {
        ArithmeticQuantity fourInches = new ArithmeticQuantity(4, Unit.INCHES);
        ArithmeticQuantity twoInches = new ArithmeticQuantity(2, Unit.INCHES);
        ArithmeticQuantity twoTsp = new ArithmeticQuantity(2, Unit.TSP);
        assertEquals(fourInches, twoInches.add(twoTsp));
    }

    @Test
    public void oneHundredCelsiusShouldEqual212Fahrenheit() {
        ScalarQuantity oneHundredCelsius = new ScalarQuantity(100, Unit.CELSIUS);
        ScalarQuantity twoHundredTwelveFahrenheit = new ScalarQuantity(212, Unit.FAHRENHEIT);
        assertEquals(oneHundredCelsius, twoHundredTwelveFahrenheit);
    }

    @Test
    public void zeroCelsiusShouldEqual32Fahrenheit() {
        ScalarQuantity zeroCelsius = new ScalarQuantity(0, Unit.CELSIUS);
        ScalarQuantity thirtyTwoFahrenheit = new ScalarQuantity(32, Unit.FAHRENHEIT);
        assertEquals(thirtyTwoFahrenheit, zeroCelsius);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotBeAbleToCreateAnArithmeticQuantityWithATemperature() {
        ArithmeticQuantity boo = new ArithmeticQuantity(0, Unit.CELSIUS);
    }

    @Test
    public void twoFeetShouldBeBetterThanFiveInches() {
        ScalarQuantity twoFeet = new ScalarQuantity(2, Unit.FEET);
        ScalarQuantity fiveInches = new ScalarQuantity(5, Unit.INCHES);
        assertTrue(twoFeet.betterThan(fiveInches));
    }
}
