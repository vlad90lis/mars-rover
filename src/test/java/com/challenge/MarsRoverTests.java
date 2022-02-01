package com.challenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MarsRoverTests {

    @Test
    @DisplayName("Move rover in direction NORTH: the y-part of the position should be incremented")
    void moveNorth() {
        testMovementInCurrentDirection(new MarsRover(3, 3, Direction.NORTH), "3 4 N");
    }

    @Test
    @DisplayName("Move rover in direction EAST: the x-part of the position should be incremented")
    void moveEast() {
        testMovementInCurrentDirection(new MarsRover(3, 3, Direction.EAST), "4 3 E");
    }

    @Test
    @DisplayName("Move rover in direction SOUTH: the y-part of the position should be decremented")
    void moveSouth() {
        testMovementInCurrentDirection(new MarsRover(3, 3, Direction.SOUTH), "3 2 S");
    }

    @Test
    @DisplayName("Move rover in direction WEST: the x-part of the position should be decremented")
    void moveWest() {
        testMovementInCurrentDirection(new MarsRover(3, 3, Direction.WEST), "2 3 W");
    }

    @Test
    @DisplayName("Move North: Throw IllegalArgumentException when rover would leave the plateau")
    void throwExceptionOnLeavingPlateauNorth() {
        assertExceptionWhenMovingOutsidePlateau(new MarsRover(4, 5, Direction.NORTH));
    }

    @Test
    @DisplayName("Move EAST: Throw IllegalArgumentException when rover would leave the plateau")
    void throwExceptionOnLeavingPlateauEast() {
        assertExceptionWhenMovingOutsidePlateau(new MarsRover(5, 4, Direction.EAST));
    }

    @Test
    @DisplayName("Move SOUTH: Throw IllegalArgumentException when rover would leave the plateau")
    void throwExceptionOnLeavingPlateauSouth() {
        assertExceptionWhenMovingOutsidePlateau(new MarsRover(1, 0, Direction.SOUTH));
    }

    @Test
    @DisplayName("Move WEST: Throw IllegalArgumentException when rover would leave the plateau")
    void throwExceptionOnLeavingPlateauWest() {
        assertExceptionWhenMovingOutsidePlateau(new MarsRover(0, 1, Direction.WEST));
    }

    private void assertExceptionWhenMovingOutsidePlateau(MarsRover rover) {
        Executable testFunction = () -> rover.moveInCurrentDirection(5, 5);
        assertThrows(IllegalArgumentException.class, testFunction);
    }

    private void testMovementInCurrentDirection(MarsRover rover, String expectedDirectedPosition) {
        rover.moveInCurrentDirection(5, 5);
        assertEquals(rover.getCurrentDirectedPositionAsString(), expectedDirectedPosition);
    }
}
