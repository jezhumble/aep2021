package edu.berkeley.aep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Airport {

    List<Airport> children = new ArrayList<>();

    public boolean canReach(Airport airport) {
        return canReach(airport, new HashSet<>());
    }

    private boolean canReach(Airport airport, Set<Airport> visited) {
        if (!visited.add(this))
            return false;
        if (airport == this)
            return true;
        for (Airport child : children) {
            if (child.canReach(airport, visited))
                return true;
        }
        return false;
    }

    public void addChild(Airport child) {
        children.add(child);
    }
}
