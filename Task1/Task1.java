
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int Played = 0;
        int Guess = 0;
        int Attempts = 0;

        boolean playAgain = true;
        while (playAgain) {
            Played++;

            int randomIntBounded = random.nextInt(100) + 1;
            int guessed = 0;
            int attempts = 0;
            final int MAX_ATTEMPTS = 7;

            System.out.println("\n--- New Game Started! ---");
            System.out.println("I've picked a number between 1 and 100. Can you guess it?");

            while (guessed != randomIntBounded && attempts < MAX_ATTEMPTS) {
                System.out.println("You have " + (MAX_ATTEMPTS - attempts) + " attempts left.");
                System.out.print("Enter your guessed number: ");

                try {
                    guessed = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    continue;
                }

                if (guessed != randomIntBounded) {
                    if (guessed < randomIntBounded) {
                        System.out.println("Your guess is too low.");
                    } else {
                        System.out.println("Your guess is too high.");
                    }
                }
                attempts++;
            }

            Attempts += attempts;

            if (guessed == randomIntBounded) {
                System.out.println("\n--- Congratulations! ---");
                System.out.println("You guessed the number " + randomIntBounded + " correctly!");
                System.out.println("You guessed it in " + attempts + " attempts.");
                Guess++;
                int score = Math.max(0, MAX_ATTEMPTS - attempts + 1);
                System.out.println("YOUR SCORE for this round: " + score);
            } else {
                System.out.println("\n--- Game Over! ---");
                System.out.println("You've used all your " + MAX_ATTEMPTS + " attempts.");
                System.out.println("The number was: " + randomIntBounded);
                System.out.println("YOUR SCORE for this round: 0" );
            }

            System.out.println("\nPlay again? (yes/no)");
            String playAgainInput = scanner.nextLine();
            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n--- Thank you for playing! ---");
        System.out.println("Total games played: " +Played);
        System.out.println("Total correct guesses: " +Guess);
        System.out.println("Total wrong guesses: " + (Played - Guess));
        System.out.println("Average attempts per game: " + (Played > 0 ? (double)Attempts /Played : 0.0));

        scanner.close();
    }
}