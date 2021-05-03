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

    public int costTo(Airport destination, HashSet<Airport> visited, CostCalculator calculator) {
        int cost = this.routeDestination.costTo(destination, visited, calculator);
        if (cost == Airport.UNREACHABLE)
            return cost;
        return calculator.calculate(cost, this.routeCost);
    }
}
