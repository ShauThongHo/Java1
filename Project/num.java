import java.util.*;

public class num {
    public static void main(String[] args){
        menu();
    }

    public static void menu(){
        Scanner input = new Scanner(System.in);

        int userInput = 0;
        System.out.println("Please enter number to choose option:");
        System.out.println("1. Play Game");
        System.out.println("2. Rule");
        System.out.println("3. Rank");
        System.out.println("4. Exit");
        userInput = input.nextInt();

        if(userInput == 1){
            playGame();
        }
        else if(userInput == 2){
            //rule();
        }
        else if(userInput == 3){
            //rank();
        }
        else if(userInput == 4){
        System.out.println("Goodbye!");
        }
        else{
            System.out.println("Invalid input, please try again.");
            menu();
        }
    }

    public static void playGame(){
        Scanner input = new Scanner(System.in);
        int userGuest = 0;
        int randomNumber = (int)(Math.random() * 10);
        int count = 0;

        //array

        System.out.println("Welcome to the game!");
        System.out.println("Please enter your guess number:");
    }
    public static void rule(){
        System.out.println("Rule of the game:");
        System.out.println("1. The game will generate a random number between 0 to 9.");
        System.out.println("2. You have to guess the number.");
        System.out.println("3. You have 3 chances to guess the number.");
        System.out.println("4. If you guess the number correctly, you win the game.");
        System.out.println("5. If you fail to guess the number, you lose the game.");
        System.out.println("6. Good luck!");
    }

    public static void rank(){
        System.out.println("Rank of the game:");
        System.out.println("1. Player 1: 10 points");
        System.out.println("2. Player 2: 9 points");
        System.out.println("3. Player 3: 8 points");
        System.out.println("4. Player 4: 7 points");
        System.out.println("5. Player 5: 6 points");
    }

}      
