package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverserTest {

    @Test
    public void oneCharacterStringShouldReturnItself() {
        Reverser reverser = new Reverser("a");
        assertEquals("a", reverser.reverse());
    }

    @Test
    public void StringShouldReverseItself() {
        Reverser reverser = new Reverser("Jez");
        assertEquals("zeJ", reverser.reverse());
    }
}
