import java.util.Random;
import java.util.Scanner;
public class GuessTheNumber {
    public static void main() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 10; 
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfAttempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (numberOfAttempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            numberOfAttempts++;

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                hasGuessedCorrectly = true;
                break;
            }
        }

        if (hasGuessedCorrectly) {
            System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts.");
        } else {
            System.out.println("Sorry, you did not guess the number. The number was " + numberToGuess + ".");
        }

        scanner.close();
    }
}
