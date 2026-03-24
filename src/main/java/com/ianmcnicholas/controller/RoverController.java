package com.ianmcnicholas.controller;

import com.ianmcnicholas.service.RoverService;
import com.ianmcnicholas.util.Command;
import com.ianmcnicholas.util.Messages;

import java.util.Scanner;

public class RoverController {

    private final RoverService roverService;
    private final Scanner scanner;

    public RoverController(RoverService roverService) {
        this.roverService = roverService;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        clearConsole();
        sleep800();

        System.out.println(roverService.welcomeMessage());

        sleep800();

        System.out.println(roverService.availableCommands());

        sleep800();

        while (true) {
            System.out.print("Input command (or type HELP): > "); // prompt
            String userInput = scanner.nextLine().trim();

            if (userInput.isEmpty()) continue;

            handleInput(userInput);
        }
    }

    public void handleInput(String userInput) {

        String[] commandParts = userInput.split("\\s+");
        String commandName = commandParts[0].toUpperCase();

        Command command;
        try {
            command = Command.valueOf(commandName);
        } catch (IllegalArgumentException e) {
            System.out.println(Messages.invalidCommand(commandName));
            return;
        }

        String output;
        if (command == Command.PLACE) {
            if (commandParts.length != 4) {
                System.out.println(Messages.invalidCommand(userInput));
                return;
            }

            int x, y;
            try {
                x = Integer.parseInt(commandParts[1]);
                y = Integer.parseInt(commandParts[2]);
            } catch (NumberFormatException e) {
                System.out.println(Messages.invalidCommand(userInput));
                return;
            }

            String dir = commandParts[3].toUpperCase();
            output = roverService.place(x, y, dir);
        } else {
            if (commandParts.length > 1) {
                System.out.println(Messages.invalidCommand(userInput));
                return;
            }
            output = switch (command) {
                case MOVE -> roverService.move();
                case LEFT -> roverService.turnLeft();
                case RIGHT -> roverService.turnRight();
                case REPORT -> roverService.report();
                case HELP -> roverService.help();
                case EXIT -> {
                    System.out.println(roverService.exit());
                    sleep800();
                    System.exit(0);
                    yield "";
                }
                default -> Messages.invalidCommand(userInput); // safety
            };
        }

        if (!output.isEmpty()) {
            System.out.println(output);
        }
    }

    private static void sleep800() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}