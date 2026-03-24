package com.ianmcnicholas.model;

public class Rover {

    private int currentX;
    private int currentY;
    private Direction direction;
    private boolean isPlaced = false;

    public Rover() {
    }

    public boolean isPlaced() {
        return this.isPlaced;
    }

    public void setIsPlaced(boolean placed) {
        isPlaced = placed;
    }

    public void setCurrentX(int x) {
        this.currentX = x;
    }

    public void setCurrentY(int y) {
        this.currentY = y;
    }

    public void setDirection(Direction d) {
        this.direction = d;
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public Direction getDirection() {
        return direction;
    }
}
