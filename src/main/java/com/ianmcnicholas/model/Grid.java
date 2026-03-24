package com.ianmcnicholas.model;

public class Grid {

    private final int xMin;
    private final int yMin;
    private final int xMax;
    private final int yMax;

    // Default constructor: square from (0,0) to (5,5)
    public Grid() {
        this.xMin = 0;
        this.yMin = 0;
        this.xMax = 5;
        this.yMax = 5;
    }

    // Constructor with custom bounds
    public Grid(int xMin, int yMin, int xMax, int yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public boolean isLocationOnGrid(int x, int y) {
        return x >= xMin && x <= xMax && y >= yMin && y <= yMax;
    }

    public int getXMin() {
        return xMin;
    }

    public int getYMin() {
        return yMin;
    }

    public int getXMax() {
        return xMax;
    }

    public int getYMax() {
        return yMax;
    }
}