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

    void rotateLeft() {
        this.currentDirection = this.currentDirection.rotateLeft();
    }

    void rotateRight() {
        this.currentDirection = this.currentDirection.rotateRight();
    }

    void moveInCurrentDirection(int boundX, int boundY) {
        int updatedX = this.currentX;
        int updatedY = this.currentY;
        switch (this.currentDirection) {
            case NORTH -> updatedY = this.currentY + 1;
            case EAST -> updatedX = this.currentX + 1;
            case SOUTH -> updatedY = this.currentY - 1;
            case WEST -> updatedX = this.currentX - 1;
        }

        if (updatedX < 0 || updatedX > boundX || updatedY < 0 || updatedY > boundY) {
            throw new IllegalArgumentException("Last command would move the rover outside of the plateau!");
        }

        this.currentX = updatedX;
        this.currentY = updatedY;
    }

    public void moveAccordingToCommands(String commands, int maxXCoordinate, int maxYCoordinate) {
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L' -> this.rotateLeft();
                case 'R' -> this.rotateRight();
                case 'M' -> this.moveInCurrentDirection(maxXCoordinate, maxYCoordinate);
                default -> throw new IllegalArgumentException("There is an unknown command! Please use only 'L','R' or 'M' as commands.");
            }
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
