package com.challenge;

public class MarsRover {
    private int currentX;
    private int currentY;
    private Direction currentDirection;

    public MarsRover(int startX, int startY, Direction startDirection) {
        this.currentX = startX;
        this.currentY = startY;
        this.currentDirection = startDirection;
    }

    void rotateLeft(){
        this.currentDirection = this.currentDirection.rotateLeft();
    }

    void rotateRight(){
        this.currentDirection = this.currentDirection.rotateRight();
    }

    void moveInCurrentDirection() {
        switch (this.currentDirection) {
            case NORTH -> this.currentY = this.currentY + 1;
            case EAST -> this.currentX = this.currentX + 1;
            case SOUTH -> this.currentY = this.currentY - 1;
            case WEST -> this.currentX = this.currentX - 1;
        }
    }

    public String getCurrentDirectedPositionAsString() {
        String position = "" + this.currentX + " " + this.currentY + " ";
        char direction = switch (this.currentDirection) {
            case NORTH -> 'N';
            case EAST -> 'E';
            case SOUTH -> 'S';
            case WEST -> 'W';
        };
        return position + direction;
    }
}
