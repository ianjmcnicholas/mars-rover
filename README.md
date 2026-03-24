MARS ROVER EXERCISE

This exercise is used as an indication of the kind of code that a candidate would write on a day-to-day basis, so please take your time and submit representative production grade code with an appropriate level of testing. Think about how the user will interact with the software. When you are done, please host your code on GitHub or package it up as a zip file and send it to us. Create an application that will take in commands and output an end state.

Description:

The application is a simulation of a toy robot moving on a square grid, of dimensions 5 units x 5 units.
There are no other obstructions on the grid surface.
The robot is free to roam around the surface of the grid, but must be prevented from falling to destruction. Any movement that would result in the robot falling from the grid must be prevented, however further valid movement commands must still be allowed.
The application should be able to read in any one of the following commands:

PLACE X,Y,F
MOVE
LEFT
RIGHT
REPORT

PLACE will put the toy robot on the grid in position X,Y and facing NORTH, SOUTH, EAST or WEST.
The origin (0,0) can be considered to be the SOUTH WEST most corner.
The first valid command to the robot is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command.
The application should discard all commands in the sequence until a valid PLACE command has been executed.
MOVE will move the toy robot one unit forward in the direction it is currently facing.
LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.
REPORT will announce the X,Y and F of the robot. This can be in any form, but standard output is sufficient.
A robot that is not on the grid should ignore the MOVE, LEFT, RIGHT and REPORT commands.
Input can be from a file, or from standard input, as the developer chooses.
Provide test data to exercise the application.
Constraints:

The toy robot must not fall off the grid during movement. This also includes the initial placement of the toy robot.
Any move that would cause the robot to fall must be ignored. Here is some example input and output:
a)
PLACE 0,0,NORTH MOVE REPORT
Output: 0,1,NORTH

b)
PLACE 0,0,NORTH LEFT REPORT
Output: 0,0,WEST

c)
PLACE 1,2,EAST MOVE MOVE LEFT MOVE REPORT
Output: 3,3,NORTH

Considerations
Consider how a user interacts with the program...
Give the user an introduction
e.g. "Welcome to the Mars Rover Programme. Please begin by placing the rover with the command PLACE X,Y,F where X is the eastings, Y is the northings, and F is direction the rover is to face. For example, PLACE 2,3,NORTH"
"The space available has the dimensions 5x5, with the south-west most corner being at 0,0."
Consider the user flow. Do you ask them for a move? Do you just provide available commands? Is there a "Help" function?
Don't make it case-sensitive - string.toLowerCase() everything then string.split(), removing whitespaces but requiring the commas.
How can the programme end?
Just print commands at the start, and then the option for help each time, or all commands if there is an error.
Confirm command each time.
