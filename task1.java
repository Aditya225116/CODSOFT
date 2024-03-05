import java.util.Random;
import java.util.Scanner;
class numberguessinggame
{
        public static void main(String[] args) 
	{
                Scanner sc = new Scanner(System.in);
                Random random = new Random();
                int minRange = 1;
                int maxRange = 100;
                int attemptsLimit = 7;
                int score = 0;
		System.out.println("Welcome to the Number Guessing Game");
                boolean playAgain = true;
		while (playAgain) 
		{
                        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                        System.out.println("You have to picked a number between " + minRange + " and " + maxRange + ". Try to guess it!");
			int attempts = 0;
                        boolean guessedCorrectly = false;
			while (attempts < attemptsLimit)
		 	{
                                System.out.print("Please enter your guess: ");
                                int guess = sc.nextInt();
                                attempts++;
				if (guess == randomNumber) 
				{
                                        System.out.println("Congratulations! You have guessed the correct number in " + attempts + " attempts.");
                                        score += attempts;
                                        guessedCorrectly = true;
                                        break;
                                } 
				else if (guess < randomNumber) 
				{
                                        System.out.println("Too low! Please try again.");
                                } 
				else 
				{
                                        System.out.println("Too high! Please try again.");
                                }
                        }
			if (!guessedCorrectly) 
			{
                                System.out.println("Sorry, you have used all your attempts.\nThe correct number was: " + randomNumber);
                     	}
			System.out.print("Would you like to play again? (yes/no): ");
                        String playAgainResponse = sc.next().toLowerCase();
                        if (!playAgainResponse.equals("yes"))
			{
                                playAgain = false;
                        }
                }

                System.out.println("Your total score is: " + score);
                System.out.println("Thanks for playing this game!");
                sc.close();
        }
}