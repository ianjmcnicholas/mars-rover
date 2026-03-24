package com.ianmcnicholas.service;


import com.ianmcnicholas.model.Direction;
import com.ianmcnicholas.model.Grid;
import com.ianmcnicholas.model.Rover;
import com.ianmcnicholas.util.Messages;

public class RoverService {

    private final Rover rover;
    private final Grid grid;

    public RoverService(Rover rover, Grid grid) {
        this.rover = rover;
        this.grid = grid;
    }

    public String place(int x, int y, String d) {
        if (!grid.isLocationOnGrid(x, y)) {
            return Messages.roverPlacementOutOfBounds(x, y, grid);
        }

        if (!Direction.exists(d)) {
            return Messages.roverDirectionInvalid(d);
        }

        rover.setCurrentX(x);
        rover.setCurrentY(y);
        rover.setDirection(Direction.valueOf(d.toUpperCase()));
        rover.setIsPlaced(true);
        return Messages.successfulPlacement(rover);
    }

    public String move() {
        if (!rover.isPlaced()) return Messages.roverNotPlaced();

        int nextX = rover.getCurrentX();
        int nextY = rover.getCurrentY();

        switch (rover.getDirection()) {
            case NORTH -> nextY++;
            case EAST -> nextX++;
            case SOUTH -> nextY--;
            case WEST -> nextX--;
        }

        if (!grid.isLocationOnGrid(nextX, nextY)) {
            return Messages.invalidMove(rover, grid);
        }

        rover.setCurrentX(nextX);
        rover.setCurrentY(nextY);
        return Messages.successfulMove();
    }

    public String turnLeft() {
        if (!rover.isPlaced()) return Messages.roverNotPlaced();
        rover.turnLeft();
        return Messages.successfulLeftTurn();
    }

    public String turnRight() {
        if (!rover.isPlaced()) return Messages.roverNotPlaced();
        rover.turnRight();
        return Messages.successfulRightTurn();
    }

    public String report() {
        if (!rover.isPlaced()) return Messages.roverNotPlaced();
        return Messages.report(rover);
    }

    public String availableCommands() {
        return Messages.availableCommands();
    }

    public String help() {
        return Messages.help(grid);
    }

    public String welcomeMessage() {
        return Messages.welcomeMessage(grid);
    }

    public String exit() {
        return Messages.exit();
    }
}
