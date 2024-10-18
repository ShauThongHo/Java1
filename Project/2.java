//9B240002A
//Ho Shau Thong

import java.util.Random;
import java.util.Scanner;

public class 2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100)+1;
        int userGuess = 0;
        int numberOfTries = 0;
        boolean win = false;
        int minNumber = 0;
        int maxNumber = 100;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("System has generated a random number between 1 until 100. Please guess it.");

        //When !win(not win the game) the system will keep asking user to enter the number
        while(!win){
            System.out.println("Please enter your guess:");
            userGuess = scanner.nextInt();
            numberOfTries++;

            //Warning when user input invalid number
            if(userGuess < 1 || userGuess > 100){
                System.out.println("Please enter the number between 1 until 100.");
            }

            //Message when user input is bigger than the answer
            else if(userGuess > numberToGuess){
                maxNumber = userGuess;
                System.out.println(minNumber "until" + maxnumber);
            }

            //Message when user input is smaller than the answer
            else if(userGuess < numberToGuess){
                minNumber = userGuess;
                System.out.println(minNumber "until" + maxnumber);
            }

            //Message when user input is correct
            else if(userGuess == numberToGuess){
                win = true;
                System.out.println("Congratulations! You have guessed the number correctly!");
                System.out.println("The number that you have tried is " + numberOfTries + " times.");
            }
        }
    }
}