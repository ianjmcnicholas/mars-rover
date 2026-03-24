MARS ROVER PROJECT

Begin by cloning this repo.  On your command line run:
```dbn-psql
git clone https://github.com/ianjmcnicholas/mars-rover
cd mars-rover
```

Ensure you have Java and Maven installed on your machine:
<pre>java -version
mvn -v </pre>

Compile the project:
<pre>mvn compile</pre>

Run the program:
<pre>mvn exec:java -Dexec.mainClass="com.ianmcnicholas.MarsRover.Main"</pre>

Run the local tests:
<pre>mvn test</pre>

The application is a simulation of a Mars rover moving on a square grid, of dimensions 5 units x 5 units.
There are no other obstructions on the grid surface.

The rover must be placed on the grid before it can be operated.  It can be re-placed at any time.
The rover is free to roam around the surface of the grid, but can only operate within the confines of the grid.

Available commands:<br>
- PLACE X Y F  
  - Place the rover at coordinates [X,Y] facing in the direction F e.g. PLACE 2 4 WEST
- MOVE
  - Move the rover 1 unit forward in the direction it is facing
- LEFT
  - Turn the rover 90° to the left
- RIGHT
  - Turn the rover 90° to the right
- REPORT
  - Output the current X,Y coordinates and direction faced by the rover
- HELP
  - Print out available commands
- EXIT
  - Exit the program

