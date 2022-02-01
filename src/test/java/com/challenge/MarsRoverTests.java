package com.challenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private void testMovementInCurrentDirection(MarsRover rover, String expectedDirectedPosition) {
        rover.moveInCurrentDirection();
        assertEquals(rover.getCurrentDirectedPositionAsString(), expectedDirectedPosition);
    }
}
