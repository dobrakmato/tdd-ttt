tic-tac-toe with use of TDD
-----------------

### Information
The application will start a Tic-Tac-Toe game between two computer-controller 
players. After each move, program pauses for 2 seconds. 

The game can end by one player winning or by draw. The end game result is
displayed on terminal.

After the game finishes the application closes itself.

### Building and running the application
Build the application using Maven. Unit test should be automatically 
run - they are part of build process.
```
mvn package
```

After the build is finished and tests passed, you can run application 
(jar with dependencies) using java:
```
java -jar target/tictactoe-1.0-SNAPSHOT-jar-with-dependencies.jar
```