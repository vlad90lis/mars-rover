# Mars Rover App

## Setup
* install Java 8 or higher

## Build and Run Application

### On Linux, MacOS and [Windows WSL](https://docs.microsoft.com/de-de/windows/wsl/install)
* open Terminal and navigate to `path/to/mars-rover`
* To build the application: 
  * `./gradlew clean build`
* To run the application: 
  * `java -jar build/libs/mars-rover.jar`
  * Or use the jar as you wish :)


### On Windows
The same as for Linux and MacOS but use `gradlew.bat` instead of `gradlew`.
And don't forget to use `\ ` instead of `/` in paths ;)


## Test Application
### Run all tests
* open Terminal and navigate to `path/to/mars-rover`
* Run `./gradlew test`
  * For Windows (not WSL) use `gradlew.bat` instead