//Import java libraries
import java.util.Scanner;
import java.util.Random;


public class GuessingGame {
    public static void main(String[] args){
       //Declare scanner
        Scanner input = new Scanner(System.in);

       //Create Random Object
        Random random = new Random();


        //Bool to Control Playing Again
        boolean playAgain = true;


        //Welcome User
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println();

        while (playAgain){
            //Prompt for difficulty and get max number
            int maxNumber = chooseDifficulty(input);
            //Play Game
            playGame(input, random, maxNumber);

            //Ask user if they want to play again
            playAgain = playAgain(input);

        }

       //Close Scanner
        input.close();
    }

    //Void to play the game
    public static void playGame(Scanner input, Random random, int maxNumber) {
        //Declare Game Variables
        int secretNumber = random.nextInt(maxNumber) - 1;
        int guess = 0;
        int attempts = 0;

        System.out.println("I am thinking of a number between 1 and " + maxNumber + ".");

        //While Loop to Handle Game
        while (guess != secretNumber) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();

            //Check for Invalid Numbers
            if (guess < 1 || guess > maxNumber) {
                System.out.println("Invalid guess! Please enter a number between 1 and " + maxNumber + ".");
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
    }
    //Method to determine difficulty
    public static int chooseDifficulty(Scanner input) {
        int choice;

        System.out.println("Select from the following difficulty levels: ");
        System.out.println("1. Easy: 1-50");
        System.out.println("2. Med: 1-100");
        System.out.println("3. Hard: 1-500");
        System.out.print("Enter your choice: ");

        choice = input.nextInt();

        //Validate the input
        while (choice < 1 || choice > 3) {
            System.out.print("Invalid choice. Please enter a number between 1, 2, or 3: ");
            choice = input.nextInt();
        }

        //Return the Difficulty
        if  (choice == 1) {
            return 50;
        } else if (choice == 2) {
            return 100;
        } else {
            return 500;
        }

    }

    //Method for Play Again
    public static boolean playAgain(Scanner input) {
        System.out.print("Would you like to play again? Enter y or n: ");
        String answer = input.next();

        //Validate the input
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
            System.out.print("Invalid answer. Please enter y or n : ");
            answer = input.next();
        }


        //Assume Play Again
        return answer.equalsIgnoreCase("y");
    }

}
