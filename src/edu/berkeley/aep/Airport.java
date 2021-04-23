package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Airport {

    List<Airport> children = new ArrayList<>();
    List<Route> routes = new ArrayList<>();
    public static final int UNREACHABLE = Integer.MAX_VALUE;

    public void addChild(Airport child) {
        children.add(child);
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

    private int hopsTo(Airport destination, Set<Airport> visited) {
        if (!visited.add(this))
            return UNREACHABLE;
        if (destination == this)
            return 0;
        int minHops = UNREACHABLE;
        for (Airport child : children) {
            int hops = child.hopsTo(destination, new HashSet<>(visited));
            if (hops < minHops) {
                minHops = hops + 1;
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
        int minHops = UNREACHABLE;
        for (Route child : routes) {
            int hops = child.costTo(destination, new HashSet<>(visited));
            if (hops < minHops) {
                minHops = hops;
            }
        }
        return minHops;
    }
}
