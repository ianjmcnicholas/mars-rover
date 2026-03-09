import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner scanner = new Scanner(System.in);

        String name;
        int age;
        float shoeSize;

        System.out.println("What is your name?");
        name = scanner.nextLine();

        System.out.println("What is your age in years?");
        age = scanner.nextInt();

        System.out.println("What is your shoe size?");
        shoeSize = scanner.nextFloat();

        System.out.println("Your name is " + name + ".");
        System.out.println("You are " + age + " years old.");
        System.out.println("Your wear a size " + shoeSize + " shoe.");
    }
}