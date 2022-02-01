# Mars Rover App

## Setup

* install Java 16 or higher

## Build and Run Application

The App's first arguments is a path to a file with the Input (see example how to run the app below)

### On Linux, MacOS and [Windows WSL](https://docs.microsoft.com/de-de/windows/wsl/install)

* open Terminal and navigate to `path/to/mars-rover`
* To build the application:
    * `./gradlew clean build` (runs also tests)
* To run the application by using TestScenario.txt:
    * `java -jar build/libs/mars-rover.jar TestScenario.txt`
    * Or use the jar as you wish :)

Instead of the TestScenario.txt you can use any Path to a File containing a valid input.

### On Windows

The same as for Linux and MacOS but use `gradlew.bat` instead of `gradlew`. And don't forget to use `\ ` instead of `/`
in paths ;)

## Test Application

### Run all tests

* open Terminal and navigate to `path/to/mars-rover`
* Run `./gradlew clean test`
    * For Windows (not WSL) use `gradlew.bat` instead