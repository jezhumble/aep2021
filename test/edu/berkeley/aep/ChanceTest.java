package edu.berkeley.aep;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ChanceTest {
    @Test
    public void coinTossChanceShouldBeEqualToItselfAndNotDieThrow() {
        Chance coinToss = new Chance(0.5);
        Chance dieThrow = new Chance(1.0 / 6.0);
        assertEquals(coinToss, coinToss);
        assertFalse(dieThrow.equals(coinToss));
    }

    @Test
    public void twoChancesWithSameProbabilityShouldBeEqual() {
        assertEquals(new Chance(0.5), new Chance(0.5));
    }

    @Test
    public void shouldBeAbleToRetrieveFromHashMapUsingChanceAsKey() {
        Map<Chance, String> map = new HashMap();
        map.put(new Chance(0.5), "Hello");
        assertEquals("Hello", map.get(new Chance(0.5)));
    }
}
