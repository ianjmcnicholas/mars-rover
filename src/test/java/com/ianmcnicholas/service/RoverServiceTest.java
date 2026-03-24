package com.ianmcnicholas.service;

import com.ianmcnicholas.model.Direction;
import com.ianmcnicholas.model.Rover;
import com.ianmcnicholas.model.Grid;
import com.ianmcnicholas.util.Messages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoverServiceTest {

    private Rover rover;
    private RoverService roverService;

    @BeforeEach
    public void setUp() {
        rover = new Rover();
        Grid grid = new Grid();
        roverService = new RoverService(rover, grid);
    }

    @Test
    public void place_validPosition_setsRover() {
        roverService.place(1, 2, "NORTH");

        assertTrue(rover.isPlaced());
        assertEquals(1, rover.getCurrentX());
        assertEquals(2, rover.getCurrentY());
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    public void place_outOfBounds_doesNotPlace() {
        roverService.place(10, 10, "NORTH");

        assertFalse(rover.isPlaced());
    }

    @Test
    public void place_invalidDirection_doesNotPlace() {
        roverService.place(1, 1, "UP");

        assertFalse(rover.isPlaced());
    }

    @Test
    public void move_whenNotPlaced_returnsError() {
        String result = roverService.move();
        assertEquals(Messages.roverNotPlaced(), result);
    }

    @Test
    public void move_validMove_updatesPosition() {
        roverService.place(0, 0, "NORTH");

        roverService.move();

        assertEquals(0, rover.getCurrentX());
        assertEquals(1, rover.getCurrentY());
    }

    @Test
    public void move_offGrid_doesNotMove() {
        roverService.place(0, 5, "NORTH");

        roverService.move();

        assertEquals(0, rover.getCurrentX());
        assertEquals(5, rover.getCurrentY());
    }

    @Test
    public void turnLeft_changesDirection() {
        roverService.place(0, 0, "NORTH");

        roverService.turnLeft();

        assertEquals(Direction.WEST, rover.getDirection());
    }

    @Test
    public void turnRight_changesDirection() {
        roverService.place(0, 0, "EAST");

        roverService.turnRight();

        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    public void report_returnsCorrectPosition() {
        roverService.place(2, 3, "EAST");

        String report = roverService.report();

        assertTrue(report.contains("2"));
        assertTrue(report.contains("3"));
        assertTrue(report.contains("EAST"));
    }
}