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
        h.addRoute(new Route(b, 100));
        b.addRoute(new Route(a, 50));
        a.addRoute(new Route(f, 300));
        b.addRoute(new Route(c, 400));
        c.addRoute(new Route(e, 200));
        c.addRoute(new Route(e, 400));
        c.addRoute(new Route(d, 50));
        d.addRoute(new Route(e, 100));
        e.addRoute(new Route(b, 500));
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

    @Test
    public void minCostFromNodeToSelfShouldBeZero() {
        assertEquals(0, h.costTo(h));
    }

    @Test
    public void minCostFromHToBShouldBe100() {
        assertEquals(100, h.costTo(b));
    }

    @Test
    public void minCostFromBToEShouldBe550() {
        assertEquals(550, b.costTo(e));
    }
}
