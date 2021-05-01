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
        return hopsTo(destination, new HashSet<>());
    }

    protected int hopsTo(Airport destination, Set<Airport> visited) {
        if (!visited.add(this))
            return UNREACHABLE;
        if (destination == this)
            return 0;
        int minHops = UNREACHABLE;
        for (Route child : routes) {
            int hops = child.hopsTo(destination, new HashSet<>(visited));
            if (hops < minHops) {
                minHops = hops;
            }
        }
        return minHops;
    }

    public int costTo(Airport destination) {
        return costTo(destination, new HashSet<>());
    }

    protected int costTo(Airport destination, Set<Airport> visited) {
        if (!visited.add(this))
            return UNREACHABLE;
        if (destination == this)
            return 0;
        int minCost = UNREACHABLE;
        for (Route child : routes) {
            int cost = child.costTo(destination, new HashSet<>(visited));
            if (cost < minCost) {
                minCost = cost;
            }
        }
        return minCost;
    }
}
