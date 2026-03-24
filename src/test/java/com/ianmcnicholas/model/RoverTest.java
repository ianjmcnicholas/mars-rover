package com.ianmcnicholas.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    @Test
    public void turnLeft_fromNorth_facesWest() {
        Rover rover = new Rover();
        rover.setDirection(Direction.NORTH);

        rover.turnLeft();

        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    public void turnRight_fromEast_facesSouth() {
        Rover rover = new Rover();
        rover.setDirection(Direction.EAST);

        rover.turnRight();

        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    public void placementFlag_worksCorrectly() {
        Rover rover = new Rover();

        assertFalse(rover.isPlaced());

        rover.setIsPlaced(true);

        assertTrue(rover.isPlaced());
    }
}