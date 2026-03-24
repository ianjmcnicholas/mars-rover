package com.ianmcnicholas.util;

import com.ianmcnicholas.model.Direction;
import com.ianmcnicholas.model.Grid;
import com.ianmcnicholas.model.Rover;

public class Messages {

    private Messages() {
    }

    /**
     * To be displayed at the start of the program.
     */
    public static String welcomeMessage(Grid grid) {
        return """

                Welcome to the Mars Rover simulator!
                Begin by placing the rover using the PLACE command
                The grid available has the coordinates [%d,%d] to [%d,%d]
                """.formatted(
                grid.getXMin(),
                grid.getYMin(),
                grid.getXMax(),
                grid.getYMax()
        );
    }

    /**
     * To be displayed at the start of the program.
     */
    public static String availableCommands() {
        return """
                Available commands:
                1. PLACE X Y F  - Place the rover at coordinates [X,Y] facing in the direction F (%s) e.g. PLACE 2 4 WEST
                2. MOVE         - Move the rover 1 unit forward in the direction it is facing
                3. LEFT         - Turn the rover 90° to the left
                4. RIGHT        - Turn the rover 90° to the right
                5. REPORT       - Output the current X,Y coordinates and direction faced by the rover
                6. HELP         - Print out available commands
                7. EXIT         - Exit the program
                """.formatted(getDirectionList());
    }

    /**
     * To be displayed when a user types HELP.
     */
    public static String help(Grid grid) {
        return """

                Available commands:
                1. PLACE X Y F  - Place the rover at coordinates [X,Y] facing in the direction F (%s) e.g. PLACE 2 4 WEST
                2. MOVE         - Move the rover 1 unit forward in the direction it is facing
                3. LEFT         - Turn the rover 90° to the left
                4. RIGHT        - Turn the rover 90° to the right
                5. REPORT       - Output the current X,Y coordinates and direction faced by the rover
                6. HELP         - Print out available commands
                7. EXIT         - Exit the program

                The grid available has the coordinates [%d,%d] to [%d,%d]
                The rover must be placed to begin with.  It can be re-placed at any time
                The rover can only operate within the confines of the grid
                """.formatted(getDirectionList(),
                grid.getXMin(),
                grid.getYMin(),
                grid.getXMax(),
                grid.getYMax()
        );
    }

    /**
     * To be displayed when the user types EXIT.
     */
    public static String exit() {
        return """
                Exiting the program. Goodbye.
                """;
    }

    /**
     * To be displayed when the user types REPORT.
     */
    public static String report(Rover rover) {
        return """
                Rover Report
                Current position: [%d,%d]
                Facing: %s
                """.formatted(
                rover.getCurrentX(),
                rover.getCurrentY(),
                rover.getDirection().name()
        );
    }

    /**
     * To be displayed when an invalid command is inputted.
     */
    public static String invalidCommand(String command) {
        return """
                Invalid command: %s
                """.formatted(
                command
        );
    }

    /**
     * To be displayed when the user types MOVE and the rover successfully completes a move.
     */
    public static String successfulMove() {
        return """
                Rover moved 1 unit forward
                """;
    }

    /**
     * To be displayed when the user types LEFT and the rover successfully turns to the left.
     */
    public static String successfulLeftTurn() {
        return """
                Rover turned left
                """;
    }

    /**
     * To be displayed when the user types RIGHT and the rover successfully turns to the right.
     */
    public static String successfulRightTurn() {
        return """
                Rover turned right
                """;
    }

    /**
     * To be displayed when the user inputs invalid coordinates in the PLACE command.
     */
    public static String roverPlacementOutOfBounds(int x, int y, Grid grid) {
        return """
                Invalid placement. The coordinates [%d,%d] are not valid for the grid [%d,%d] to [%d,%d]
                """.formatted(
                x,
                y,
                grid.getXMin(),
                grid.getYMin(),
                grid.getXMax(),
                grid.getYMax()
        );
    }

    /**
     * To be displayed when the user inputs an invalid direction in the PLACE command.
     */
    public static String roverDirectionInvalid(String invalidDirection) {
        return """
                Invalid placement. The direction '%s' is not valid
                Available directions are: %s
                """.formatted(
                invalidDirection,
                getDirectionList()
        );
    }

    /**
     * To be displayed when the user types MOVE but the move would take the rover off the grid.
     */
    public static String invalidMove(Rover rover, Grid grid) {
        return """
                Invalid movement. The rover has reached the edge of the grid
                Rover coordinates: [%d,%d], facing %s
                Grid coordinates: [%d,%d] to [%d,%d]
                Please turn the rover away from the edge of the grid to continue
                """.formatted(
                rover.getCurrentX(),
                rover.getCurrentY(),
                rover.getDirection().name(),
                grid.getXMin(),
                grid.getYMin(),
                grid.getXMax(),
                grid.getYMax()
        );
    }

    /**
     * To be displayed when the user types an available command but the rover has not yet been placed.
     */
    public static String roverNotPlaced() {
        return """
                Invalid command. The rover is not placed yet
                """;
    }

    /**
     * To be displayed when the user types PLACE and the rover is placed successfully.
     */
    public static String successfulPlacement(Rover rover) {
        return """
                Rover Placed
                Current position: [%d,%d]
                Facing: %s
                """.formatted(
                rover.getCurrentX(),
                rover.getCurrentY(),
                rover.getDirection().name()
        );
    }

    private static String getDirectionList() {
        return String.join(", ",
                java.util.Arrays.stream(Direction.values())
                        .map(Enum::name)
                        .toArray(String[]::new)
        );
    }

}
