package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Airport {

    List<Airport> children = new ArrayList<>();
    public static int UNREACHABLE = Integer.MAX_VALUE;

    public boolean canReach(Airport destination) {
        return canReach(destination, new HashSet<>());
    }

    private boolean canReach(Airport destination, Set<Airport> visited) {
        if (!visited.add(this))
            return false;
        if (destination == this)
            return true;
        for (Airport child : children) {
            if (child.canReach(destination, visited))
                return true;
        }
        return false;
    }

    public void addChild(Airport child) {
        children.add(child);
    }

    public int hopsTo(Airport destination) {
        return hopsTo(destination, new HashSet<>());
    }

    private int hopsTo(Airport destination, Set<Airport> visited) {
        if (!visited.add(this))
            return UNREACHABLE;
        if (destination == this)
            return 0;
        for (Airport child : children) {
            int hops = child.hopsTo(destination, visited);
            if (hops != UNREACHABLE)
                return hops + 1;
        }
        return UNREACHABLE;
    }
}
