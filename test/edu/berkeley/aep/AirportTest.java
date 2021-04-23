package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class AirportTest {

    public static Airport a = new Airport();
    public static Airport b = new Airport();
    public static Airport c = new Airport();
    public static Airport d = new Airport();
    public static Airport e = new Airport();
    public static Airport f = new Airport();
    public static Airport g = new Airport();
    public static Airport h = new Airport();

    static {
        h.addChild(b);
        b.addChild(a);
        a.addChild(f);
        b.addChild(c);
        c.addChild(d);
        c.addChild(e);
        c.addChild(e);
        d.addChild(e);
        e.addChild(b);
    }

    @Test
    public void airportShouldBeAbleToReachSelf() {
        Airport airport = new Airport();
        assertTrue(airport.canReach(airport));
    }

    @Test
    public void airportShouldBeAbleToReachChild() {
        Airport start = new Airport();
        Airport end = new Airport();
        start.addChild(end);
        assertTrue(start.canReach(end));
    }

    @Test
    public void airportShouldNotBeAbleToReachDisconnectedNode() {
        Airport start = new Airport();
        Airport end = new Airport();
        assertFalse(start.canReach(end));
    }

    @Test
    public void airportHShouldBeAbleToReachE() {
        assertTrue(h.canReach(e));
    }

    @Test
    public void airportBShouldNotBeAbleToReachG() {
        assertFalse(b.canReach(g));
    }

    @Test
    public void hopsToSelfShouldBeZero() {
        assertEquals(0, h.hopsTo(h));
    }

    @Test
    public void hopsFromBToFShouldBeTwo() {
        assertEquals(2, b.hopsTo(f));
    }

    @Test
    public void gShouldBeUnreachableFromB() {
        assertEquals(Airport.UNREACHABLE, b.hopsTo(g));
    }

    @Test
    public void minHopCountFromCToBShouldBeTwo() {
        assertEquals(2, c.hopsTo(b));
    }
}
