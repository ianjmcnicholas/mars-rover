package com.ianmcnicholas.controller;

import com.ianmcnicholas.model.Direction;
import com.ianmcnicholas.model.Grid;
import com.ianmcnicholas.service.RoverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.ianmcnicholas.model.Rover;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class RoverControllerTest {

    private Rover rover;
    private RoverController roverController;

    @BeforeEach
    public void setUp() {
        rover = new Rover();
        Grid grid = new Grid();
        RoverService roverService = new RoverService(rover, grid);
        roverController = new RoverController(roverService);
    }

    @Test
    public void invalidCommandTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("badCommand");

        String output = out.toString();

        assertTrue(output.contains("Invalid command:"));
    }

    @Test
    public void roverNotPlacedTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("MOVE");

        String output = out.toString();

        assertTrue(output.contains("The rover is not placed yet"));
        assertFalse(rover.isPlaced());
    }

    @Test
    public void placeWithoutArgumentsInvalidTest() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("PLACE");
        String output = out.toString();

        assertTrue(output.contains("Invalid command:"));
    }

    @Test
    public void outOfBoundsPlacementTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("PLACE 0 6 NORTH");

        String output = out.toString();

        assertTrue(output.contains("Invalid placement") &&
                output.contains("The coordinates") &&
                output.contains("are not valid"));
        assertFalse(rover.isPlaced());
    }

    @Test
    public void invalidDirectionPlacementTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("PLACE 0 0 FORWARD");

        String output = out.toString();

        assertTrue(output.contains("Invalid placement") &&
                output.contains("The direction") &&
                output.contains("is not valid"));
        assertFalse(rover.isPlaced());
    }

    @Test
    public void validPlacementTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("PLACE 0 0 NORTH");

        String output = out.toString();

        assertTrue(output.contains("Rover Placed"));
        assertTrue(rover.isPlaced());
        assertEquals(Direction.NORTH, rover.getDirection());
        assertEquals(0, rover.getCurrentX());
        assertEquals(0, rover.getCurrentY());
    }

    @Test
    public void commandWithArgumentsInvalidTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("PLACE 0 0 NORTH"); // valid placement
        roverController.handleInput("MOVE 1");

        String output = out.toString();

        assertTrue(output.contains("Invalid command:"));
    }

    @Test
    public void moveMovesTheRoverTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("PLACE 0 0 NORTH"); // valid placement
        roverController.handleInput("MOVE");

        String output = out.toString();

        assertTrue(output.contains("Rover moved 1 unit forward"));
        assertTrue(rover.isPlaced());
        assertEquals(Direction.NORTH, rover.getDirection());
        assertEquals(0, rover.getCurrentX());
        assertEquals(1, rover.getCurrentY());
    }
    @Test
    public void invalidMoveTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("PLACE 0 0 WEST"); // valid placement
        roverController.handleInput("MOVE");

        String output = out.toString();

        assertTrue(output.contains("The rover has reached the edge of the grid"));
        assertTrue(rover.isPlaced());
        assertEquals(Direction.WEST, rover.getDirection());
        assertEquals(0, rover.getCurrentX());
        assertEquals(0, rover.getCurrentY());
    }

    @Test
    public void successfulLeftTurnTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("PLACE 0 0 NORTH"); // valid placement
        roverController.handleInput("LEFT");

        String output = out.toString();

        assertTrue(output.contains("Rover turned left"));
        assertTrue(rover.isPlaced());
        assertEquals(Direction.WEST, rover.getDirection());
        assertEquals(0, rover.getCurrentX());
        assertEquals(0, rover.getCurrentY());
    }

    @Test
    public void successfulRightTurnTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("PLACE 0 0 NORTH"); // valid placement
        roverController.handleInput("RIGHT");

        String output = out.toString();

        assertTrue(output.contains("Rover turned right"));
        assertTrue(rover.isPlaced());
        assertEquals(Direction.EAST, rover.getDirection());
        assertEquals(0, rover.getCurrentX());
        assertEquals(0, rover.getCurrentY());
    }

    @Test
    public void reportTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        roverController.handleInput("PLACE 0 0 WEST"); // valid placement
        roverController.handleInput("REPORT");

        String output = out.toString();

        assertTrue(rover.isPlaced());
        assertEquals(Direction.WEST, rover.getDirection());
        assertEquals(0, rover.getCurrentX());
        assertEquals(0, rover.getCurrentY());

        assertTrue(output.contains(String.valueOf(rover.getCurrentX())));
        assertTrue(output.contains(String.valueOf(rover.getCurrentY())));
        assertTrue(output.contains(String.valueOf(rover.getDirection())));
        assertTrue(output.contains("Rover Report"));
        assertTrue(output.contains("Current position"));
        assertTrue(output.contains("Facing"));


    }
}
