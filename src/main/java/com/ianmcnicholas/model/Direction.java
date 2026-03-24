package com.ianmcnicholas.model;

import java.util.Arrays;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction turnLeft() {
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };
    }

    public Direction turnRight() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public static boolean exists(String dir) {
        return Arrays.stream(values())
                .anyMatch(direction -> direction.name().equals(dir));
    }
}