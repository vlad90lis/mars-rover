package com.challenge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTests {

    @Test
    @DisplayName("Given North: When rotated to left and right, should result in WEST and EAST")
    void rotateNorth() {
        testRotation(Direction.NORTH, Direction.WEST, Direction.EAST);
    }

    @Test
    @DisplayName("Given EAST: When rotated to left and right, should result in NORTH and SOUTH")
    void rotateEast() {
        testRotation(Direction.EAST, Direction.NORTH, Direction.SOUTH);
    }

    @Test
    @DisplayName("Given South: When rotated to left and right, should result in EAST and WEST")
    void rotateSouth() {
        testRotation(Direction.SOUTH, Direction.EAST, Direction.WEST);
    }

    @Test
    @DisplayName("Given WEST: When rotated to left and right, should result in SOUTH and NORTH")
    void rotateWest() {
        testRotation(Direction.WEST, Direction.SOUTH, Direction.NORTH);
    }

    void testRotation(Direction direction, Direction expectedLeftRotation, Direction expectedRightRotation) {
        assertEquals(direction.rotateLeft(), expectedLeftRotation);
        assertEquals(direction.rotateRight(), expectedRightRotation);
    }
}
