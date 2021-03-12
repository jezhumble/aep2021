package edu.berkeley.aep;

public interface Bestable<T> {
    boolean betterThan(T other);
}
