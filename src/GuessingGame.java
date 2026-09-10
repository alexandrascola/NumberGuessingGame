//Import java libraries
import java.util.Scanner;
import java.util.Random;


public class GuessingGame {
    public static void main(String[] args){
       //Declare scanner
        Scanner input = new Scanner(System.in);

       //Create Random Object
        Random random = new Random();

       //Declare Global Variables
        int secretNumber = random.nextInt(100) -1;
        int guess = 0;
        int attempts = 0;

        //Implement Difficulty
        final int EASY = 50;
        final int MED = 100;
        final int HARD = 500;
        String userOption;
        String difficulty;

        //Welcome User
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println();
        System.out.println("Select from the following difficulty levels: ");
        System.out.println("EASY = 1 to " + (EASY));
        System.out.println("MED = 1 to " + (MED));
        System.out.println("Hard = 1 to " + (HARD));
        //System.out.println("I am thinking of a number between 1 and 100");




       //While Loop to Handle Game
        while (guess != secretNumber){
            System.out.print("Enter your guess: ");
            guess = input.nextInt();

            //check for invalid numbers
            if (guess < 1 || guess > 100) {
                System.out.println("Invalid guess! Please enter a number between 1 and 100");
            } else {
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too LOW, try again!");
                } else if (guess > secretNumber) {
                    System.out.println("Too HIGH, try again!");
                } else {
                    System.out.println("Congratulations! You guessed the number!");
                    System.out.println("You guessed the number " + secretNumber + " in " + attempts + " attempts");
                }
            }

            System.out.println();
        }

       //close scanner
        input.close();
    }

    //Bool Method to replace the "if" logic
    private static boolean checkGuess(int MaxNumber){

    }
    
}
