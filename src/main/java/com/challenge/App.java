package com.challenge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Please provide a String for setup description as the first input argument!");
            return;
        }
        Path filePath = Paths.get(new File(args[0]).toURI());

        List<String> setupLines = Files.lines(filePath).toList();

        if (setupLines.size() < 3 || setupLines.size() % 2 == 0) {
            System.out.println("Please provide more information for the setup!");
            return;
        }

        String[] plateauBounds = setupLines.get(0).split(" ");
        if (plateauBounds.length != 2) {
            System.out.println("The upper-right corner of the plateau is not defined or has a wrong format!");
            return;
        }
        int maxXCoordinate = Integer.parseInt(plateauBounds[0]);
        int maxYCoordinate = Integer.parseInt(plateauBounds[1]);

        int numberOfRovers = setupLines.size() / 2;
        List<MarsRover> rovers = new ArrayList<>(numberOfRovers);
        List<String> correspondingCommands = new ArrayList<>(numberOfRovers);

        for (int i = 1; i < setupLines.size(); i++) {
            String line = setupLines.get(i);
            if (i % 2 == 1) {
                String[] roverParameters = line.split(" ");
                int startX = Integer.parseInt(roverParameters[0]);
                int startY = Integer.parseInt(roverParameters[1]);
                Direction direction = Direction.directionFromString(roverParameters[2]);
                MarsRover rover = new MarsRover(startX, startY, direction);
                rovers.add(rover);
                System.out.println("Rover" + (i / 2 + 1) + " starts at " + rover.getCurrentDirectedPositionAsString());
            } else {
                correspondingCommands.add(line);
            }
        }

        System.out.println();

        for (int i = 0; i < rovers.size(); i++) {
            MarsRover rover = rovers.get(i);
            String command = correspondingCommands.get(i);
            rover.moveAccordingToCommands(command, maxXCoordinate, maxYCoordinate);
            System.out.println("Rover" + (i + 1) + " moves to " + rover.getCurrentDirectedPositionAsString());
            System.out.println("by the following commands: " + command);
            System.out.println();
        }
    }
}
