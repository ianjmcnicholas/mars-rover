import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);

        String name;
        String age;
        float shoeSize;

        System.out.println("What is your name?");
        name = scanner.nextLine();


        int intAge = 0;
        boolean validIntAge = false;

        do {
            System.out.println("What is your age in years?");
            age = scanner.nextLine();
            try {
                // todo - you can put in custom validations here
                intAge = Integer.parseInt(age);
                if ((intAge <= 0) || (intAge > 150)) {
                    intAge = 0;
                    throw new NumberFormatException("Not a valid age");
                }
                validIntAge = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Incorrect format entered for age.  Age must be a whole number between 1 and 150.");
            }
        } while (!validIntAge);

        System.out.println("What is your shoe size?");
        shoeSize = scanner.nextFloat();

        System.out.println("Your name is " + name + ".");
        System.out.println("You are " + age + " years old.");
        System.out.println("Your wear a size " + shoeSize + " shoe.");

        scanner.close();

        // TODO - just use scanner.nextLine, and then convert that into the data type you need - otherwise you might pick up garbage from the user.
        //  e.g. you want a number like 2, but the user enters some chars. you will get a number format exception that you can catch and deal with.
    }
}