package com.ianmcnicholas;

import com.ianmcnicholas.controller.RoverController;
import com.ianmcnicholas.model.Grid;
import com.ianmcnicholas.model.Rover;
import com.ianmcnicholas.service.RoverService;

public class Main {
    public static void main(String[] args) {
        Rover rover = new Rover();
        Grid grid = new Grid();
        RoverService roverService = new RoverService(rover, grid);

        RoverController roverController = new RoverController(roverService);
        roverController.run();
    }
}