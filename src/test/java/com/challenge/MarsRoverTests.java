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

    @Test
    @DisplayName("Move rover from (1 2 N) to (1 3 N) by commands")
    void moveRoverByCommandsTo13N() {
        MarsRover rover = new MarsRover(1, 2, Direction.NORTH);
        rover.moveAccordingToCommands("LMLMLMLMM", 5, 5);
        assertEquals(rover.getCurrentDirectedPositionAsString(), "1 3 N");
    }

    @Test
    @DisplayName("Move rover from (3 3 E) to (5 1 E) by commands")
    void moveRoverByCommandsTo51E() {
        MarsRover rover = new MarsRover(3, 3, Direction.EAST);
        rover.moveAccordingToCommands("MMRMMRMRRM", 5, 5);
        assertEquals(rover.getCurrentDirectedPositionAsString(), "5 1 E");
    }

    @Test
    @DisplayName("Fail movement of the rover when the commands contain an unknown one")
    void failRoverMovementOnUnknownCommand() {
        MarsRover rover = new MarsRover(3, 3, Direction.EAST);
        Executable testFunction = () -> rover.moveAccordingToCommands("MLMX", 5, 5);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, testFunction);
        assertEquals(illegalArgumentException.getMessage(), "There is an unknown command! Please use only 'L','R' or 'M' as commands.");
    }

    private void assertExceptionWhenMovingOutsidePlateau(MarsRover rover) {
        Executable testFunction = () -> rover.moveInCurrentDirection(5, 5);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, testFunction);
        assertEquals(illegalArgumentException.getMessage(), "Last command would move the rover outside of the plateau!");
    }

    private void testMovementInCurrentDirection(MarsRover rover, String expectedDirectedPosition) {
        rover.moveInCurrentDirection(5, 5);
        assertEquals(rover.getCurrentDirectedPositionAsString(), expectedDirectedPosition);
    }
}
