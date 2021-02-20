package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuantityTest {
    @Test
    public void oneFootShouldEqualTwelveInches() {
        Quantity oneFoot = new Quantity(1, Unit.FEET);
        Quantity twelveInches = new Quantity(12, Unit.INCHES);
        assertEquals(twelveInches, oneFoot);
    }

    @Test
    public void threeFeetShouldEqualOneYard() {
        Quantity threeFeet = new Quantity(3, Unit.FEET);
        Quantity oneYard = new Quantity(1, Unit.YARDS);
        assertEquals(oneYard, threeFeet);
    }
    
    @Test
    public void oneMileShouldEqual1760Feet() {
        Quantity oneMile = new Quantity(1, Unit.MILES);
        Quantity one760Feet = new Quantity(1760, Unit.YARDS);
        assertEquals(oneMile, one760Feet);
    }

    @Test
    public void oneTbspShouldEqualThreeTsp() {
        Quantity oneTbsp = new Quantity(1, Unit.TBSP);
        Quantity threeTsp = new Quantity(3, Unit.TSP);
        assertEquals(oneTbsp, threeTsp);
    }

    @Test
    public void oneOzShouldEqualTwoTbsp() {
        Quantity oneOz = new Quantity(1, Unit.OZ);
        Quantity twoTbsp = new Quantity(2, Unit.TBSP);
        assertEquals(oneOz, twoTbsp);
    }

    @Test
    public void eightOzShouldEqualOneCup() {
        Quantity eightOz = new Quantity(8, Unit.OZ);
        Quantity oneCup = new Quantity(1, Unit.CUP);
        assertEquals(eightOz, oneCup);
    }

    @Test
    public void twoInchesPlusTwoInchesShouldEqualFourInches() {
        Quantity fourInches = new Quantity(4, Unit.INCHES);
        Quantity twoInches = new Quantity(2, Unit.INCHES);
        assertEquals(fourInches, twoInches.add(twoInches));
    }

    @Test
    public void twoTbspPlusOneOzShouldEqual12Tsp() {
        Quantity twoTbsp = new Quantity(2, Unit.TBSP);
        Quantity oneOz = new Quantity(1, Unit.OZ);
        assertEquals(new Quantity(12, Unit.TSP), oneOz.add(twoTbsp));
    }

    @Test(expected = IllegalArgumentException.class)
    public void twoInchesPlusTwoTspShouldNotEqualFourInches() {
        Quantity fourInches = new Quantity(4, Unit.INCHES);
        Quantity twoInches = new Quantity(2, Unit.INCHES);
        Quantity twoTsp = new Quantity(2, Unit.TSP);
        assertEquals(fourInches, twoInches.add(twoTsp));
    }
}
