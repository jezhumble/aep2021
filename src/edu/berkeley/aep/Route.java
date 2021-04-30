package edu.berkeley.aep;

import java.util.HashSet;

// Understands a cost to a destination
public class Route {
    private final Airport routeDestination;
    private final int routeCost;

    public Route(Airport destination, int cost) {
        this.routeDestination = destination;
        this.routeCost = cost;
    }

    public int costTo(Airport destination, HashSet<Airport> visited) {
        int cost = this.routeDestination.costTo(destination, visited);
        if (cost == Airport.UNREACHABLE)
            return cost;
        return cost + this.routeCost;
    }

    public int hopsTo(Airport destination, HashSet<Airport> visited) {
        int cost = this.routeDestination.hopsTo(destination, visited);
        if (cost == Airport.UNREACHABLE)
            return cost;
        return cost + 1;
    }
}
