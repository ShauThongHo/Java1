//9B240002A
//Ho Shau Thong

import java.util.Random;
import java.util.Scanner;

public class num{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int level = 0;
        int numberToGuess = random.nextInt(100) + 1;
        int userGuess = 0;
        int numberOfTries = 0;
        boolean win = false;
        int minNumber = 1;
        int maxNumber = 100;
        int dividingLine = 60;
        boolean restart = true;
        int playRound = 0;

        System.out.println("-".repeat(dividingLine));
        System.out.println("Welcome to the Number Guessing Game!");

        while (restart) {
            System.out.println("Please select the level of the game:");
            System.out.println("1. Easy guest correct 1 number");
            System.out.println("2. Medium guest correct 3 number");
            System.out.println("3. Hard guest correct 5 number");
            level = scanner.nextInt();
            if (level == 1) {
                playRound = 1;
            } else if (level == 2) {
                playRound = 3;
            } else if (level == 3) {
                playRound = 5;
            } else {
                System.out.println("Please enter the correct level.");
            }
            System.out.println("System has generated a random number between 1 until 100.");
            System.out.println("Please guess it.");
            System.out.println("-".repeat(dividingLine));

            // When !win(not win the game) the system will keep asking user to enter the
            // number
            while (!win) {
                System.out.print("Please enter your guess:");
                userGuess = scanner.nextInt();
                numberOfTries++;

                // Warning when user input invalid number
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("-".repeat(dividingLine));
                    System.out
                            .println("Please enter the number between " + minNumber + " until " + maxNumber + ".");
                }

                // Massage when user input the number that lower or highter than the previous
                // guess
                else if (userGuess < minNumber || userGuess > maxNumber) {
                    System.out.println("-".repeat(dividingLine));
                    System.out.println("You have entered the number before. Please enter the number between "
                            + minNumber + " until " + maxNumber + ".");
                }

                // Message when user input is bigger than the answer
                else if (userGuess > numberToGuess) {
                    maxNumber = userGuess - 1;
                    System.out.println("-".repeat(dividingLine));
                    System.out.println(minNumber + " until " + maxNumber);
                }

                // Message when user input is smaller than the answer
                else if (userGuess < numberToGuess) {
                    minNumber = userGuess + 1;
                    System.out.println("-".repeat(dividingLine));
                    System.out.println(minNumber + " until " + maxNumber);
                }

                // Message when user input is correct
                else if (userGuess == numberToGuess) {
                    win = true;
                    System.out.println("-".repeat(60));
                    System.out.println("Congratulations! You have guessed the number correctly!");
                    System.out.println("The number that you have tried is " + numberOfTries + " times.");
                    System.out.println("-".repeat(60));
                    restart = false;

                    // Ask user to play again or not
                    System.out.println("Do you want to play again? (Y/N)");
                    String choice = scanner.next();
                    if (choice == ("Y") || choice == ("y")) {
                        restart = true;
                        numberOfTries = 0;
                        numberToGuess = random.nextInt(level) + 1;
                        minNumber = 1;
                        maxNumber = 100;
                    } else {
                        System.out.println("Thank you for playing the game!");
                        scanner.close();
                    }

                }
            }
            win = false;
        }
    }
}