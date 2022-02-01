package com.challenge;

public enum Direction {

    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private final int directionIndex;

    public Direction rotateLeft() {
        return Direction.values()[(this.directionIndex + 3) % 4];
    }

    public Direction rotateRight() {
        return Direction.values()[(this.directionIndex + 1) % 4];
    }

    Direction(int directionIndex) {
        this.directionIndex = directionIndex;
    }

    public static Direction directionFromString(String direction) {
        return switch (direction) {
            case "N" -> NORTH;
            case "E" -> EAST;
            case "S" -> SOUTH;
            case "W" -> WEST;
            default -> throw new IllegalArgumentException("No corresponding direction for String " + direction);
        };
    }
}
