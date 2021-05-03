package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Understands routes to other airports
public class Airport {

    List<Route> routes = new ArrayList<>();
    public static final int UNREACHABLE = Integer.MAX_VALUE;

    public void addChild(Airport child) {
        routes.add(new Route(child, 0));
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public boolean canReach(Airport destination) {
        return hopsTo(destination) != UNREACHABLE;
    }

    public int hopsTo(Airport destination) {
        CostCalculator hopsCalculator = new CostCalculator() {
            @Override
            public int calculate(int cost, int routeCost) {
                return cost + 1;
            }
        };
        return costTo(destination, new HashSet<>(), hopsCalculator);
    }

    public int costTo(Airport destination) {
        CostCalculator costCalculator = new CostCalculator() {
            @Override
            public int calculate(int cost, int routeCost) {
                return cost + routeCost;
            }
        };
        return costTo(destination, new HashSet<>(), costCalculator);
    }

    protected int costTo(Airport destination, Set<Airport> visited, CostCalculator calculator) {
        if (!visited.add(this))
            return UNREACHABLE;
        if (destination == this)
            return 0;
        int minCost = UNREACHABLE;
        for (Route child : routes) {
            int cost = child.costTo(destination, new HashSet<>(visited), calculator);
            if (cost < minCost) {
                minCost = cost;
            }
        }
        return minCost;
    }
}
