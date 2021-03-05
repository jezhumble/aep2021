package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BesterTest {
    @Test
    public void fiveYardsShouldBeTheBest() {
        var fiveYards = new ScalarQuantity(5, Unit.YARDS);
        var twelveFeet = new ScalarQuantity(12, Unit.FEET);
        var threeInches = new ScalarQuantity(3, Unit.INCHES);
        var bester = new Bester(fiveYards, twelveFeet, threeInches);
        assertEquals(fiveYards, bester.best());
    }

    @Test(expected = IllegalArgumentException.class)
    public void passingInEmptyArrayShouldThrowException() {
        new Bester();
    }

    @Test
    public void coinTossProbabilityShouldBeBetterThanDieRoll() {
        var coinToss = new Chance(0.5);
        var dieRoll = new Chance(1/6);
        var bester = new Bester(coinToss, dieRoll);
        assertEquals(coinToss, bester.best());
    }

}
