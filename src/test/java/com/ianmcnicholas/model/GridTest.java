package com.ianmcnicholas.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    @Test
    public void validPosition_returnsTrue() {
        Grid grid = new Grid(0, 0, 5, 5);

        assertTrue(grid.isLocationOnGrid(3, 3));
    }

    @Test
    public void xBelowMin_returnsFalse() {
        Grid grid = new Grid(0, 0, 5, 5);

        assertFalse(grid.isLocationOnGrid(-1, 3));
    }

    @Test
    public void yAboveMax_returnsFalse() {
        Grid grid = new Grid(0, 0, 5, 5);

        assertFalse(grid.isLocationOnGrid(3, 6));
    }

    @Test
    public void boundaryValues_areValid() {
        Grid grid = new Grid(0, 0, 5, 5);

        assertTrue(grid.isLocationOnGrid(0, 0));
        assertTrue(grid.isLocationOnGrid(5, 5));
    }

    @Test
    public void defaultValueOfGrid_ZeroToFive() {
        Grid grid = new Grid();
        assertEquals(0, grid.getXMin());
        assertEquals(0, grid.getYMin());
        assertEquals(5, grid.getXMax());
        assertEquals(5, grid.getYMax());
    }
}