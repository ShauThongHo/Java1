import java.util.*;

public class num2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        boolean quitGame = false;
        int level = 0;
        int[] timeRank = new int[5];
        String[] nameRank = new String[5];
        String name = "";
        int time = 0;

        Arrays.fill(timeRank, Integer.MAX_VALUE);  //Initialize the leaderboard as an empty value (maximum)

        while (!quitGame) {
            devider();
            System.out.println("Please enter number to choose option:");
            System.out.println("1. Play Game");
            System.out.println("2. Rule");
            System.out.println("3. Rank");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice:");
            userInput = input.nextInt();
            
            if (userInput == 1) {
                devider();
                System.out.println("You have chosen to play the game.");
                do {
                    devider();
                    System.out.println("Please enter the level of difficulty:");
                    System.out.println("1. Easy");
                    System.out.println("2. Medium");
                    System.out.println("3. Hard");
                    System.out.print("Please enter your choice:");
                    userInput = input.nextInt();
                    if (userInput == 1)
                        level = 4;
                    else if (userInput == 2)
                        level = 6;
                    else if (userInput == 3)
                        level = 8;
                    else {
                        System.out.println("Invalid input, please try again.");
                        continue;  //Reselect difficulty
                    }

                    String[] winnerData = playGame(level);
                    name = winnerData[0];
                    time = Integer.parseInt(winnerData[1]);

                    //Insert to leaderboard
                    updateRank(nameRank, timeRank, name, time);
                    quitGame = backMenu();

                } while (userInput != 1 && userInput != 2 && userInput != 3);
            } else if (userInput == 2) {
                rule();
            } else if (userInput == 3) {
                rank(nameRank, timeRank);
            } else if (userInput == 4) {
                System.out.println("Goodbye!");
                quitGame = true;
            } else {
                devider();
                System.out.println("Invalid input, please try again.");
            }
        }
    }

    public static String[] playGame(int level) {
        Scanner input = new Scanner(System.in);
        String[] history = new String[10];
        Arrays.fill(history, "    ");
        String userGuest = "";
        int count = 0;
        int[] randomNum = new int[level];
        int[] a = new int[10];
        int[] b = new int[10];
        int[] guessNum = new int[level];
        int userGuestLength = 0;
        int[] temp = new int[level];
        String name = "";
        long startTime = System.currentTimeMillis();
        long endTime = 0;

        //Generate random numbers
        for (int i = 0; i < level; i++) {
            randomNum[i] = (int) (Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if (randomNum[i] == randomNum[j]) {
                    i--;
                    break;
                }
            }
        }
        devider();
        System.out.println("Welcome to the game!");
        System.out.println("The game has generated " + level + " random numbers between 0 to 9.");
        System.out.println("You have 10 chances to guess the number.");
        //test
        System.out.println("The correct number is: " + Arrays.toString(randomNum));

        for (int i = 1; i <= 10; i++, count++) {
            devider();
            //Print History
            for (int j = 0; j < 10; j++) {
                System.out.printf("%d. %s %dA %dB\n", j + 1, history[j], a[j], b[j]);
            }

            devider();
            System.out.print("Please enter your " + level + " guess number:");
            userGuest = input.next();
            userGuestLength = userGuest.length();
            if (userGuestLength > level || userGuestLength < level) {
                devider();
                System.out.println("Invalid input, please try again.");
                i--;
                count--;
                continue;
            }
            history[count] = userGuest;

            //Convert the user's guessed number into an array
            for (int k = level - 1; k >= 0; k--) {
                guessNum[k] = userGuest.charAt(k) - '0';
            }

            //Save the original random number
            for (int p = 0; p < level; p++) {
                temp[p] = randomNum[p];
            }

            //Check if you have won
            for (int k = 0; k < level; k++) {
                if (randomNum[k] == guessNum[k]) {
                    b[count]++;
                }
                for (int l = 0; l < level; l++) {
                    if (randomNum[l] == guessNum[k]) {
                        a[count]++;
                        randomNum[l] = -1;
                    }
                }
                if (b[count] == level) {
                    System.out.println("Congratulations! You win the game!");
                    System.out.print("Please enter your name: ");
                    name = input.next();
                    endTime = System.currentTimeMillis();
                    String time = String.valueOf((endTime - startTime) / 1000);
                    return new String[] { name, time };
                }
            }
            //Recover random numbers
            for (int p = 0; p < level; p++) {
                randomNum[p] = temp[p];
            }
        }
        devider();
        System.out.println("Sorry! You lose the game!");
        System.out.println("The correct number is: " + Arrays.toString(randomNum));
        return new String[] { "", "0" };
    }

    public static void rule() {
        System.out.println("Rule of the game:");
        System.out.println("1. The game will generate random number between 0 to 9.");
        System.out.println("2. A is for correct number but wrong position.");
        System.out.println("3. B is for correct number and correct position.");
        System.out.println("4. If you guess all the number correctly, you win the game.");
        System.out.println("5. If you fail to guess the number, you lose the game.");
        System.out.println("6. Good luck!");
    }

    public static void rank(String[] name, int[] time) {
        System.out.println("Rank of the game:");
        for (int i = 0; i < 5; i++) {
            if (name[i] != null) {
                System.out.println((i + 1) + ". " + name[i] + " " + time[i] + "s");
            }
        }
    }

    public static boolean backMenu() {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        boolean quitGame = false;

        devider();
        System.out.println("Do you want back to menu? [Y/N]");
        userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("Y")) {
            quitGame = false;
        } else if (userInput.equalsIgnoreCase("N")) {
            quitGame = true;
        } else {
            System.out.println("Invalid input, please try again.");
        }
        return quitGame;
    }

    public static void updateRank(String[] nameRank, int[] timeRank, String name, int time) {
        //If there is a worse score than the new score in the current ranking, insert the new score
        for (int i = 0; i < 5; i++) {
            if (time < timeRank[i]) {
                //Move the following rankings backward
                for (int j = 4; j > i; j--) {
                    timeRank[j] = timeRank[j - 1];
                    nameRank[j] = nameRank[j - 1];
                }
                //Insert New Grade
                timeRank[i] = time;
                nameRank[i] = name;
                break;
            }
        }
    }

    public static void devider() {
        for (int i = 0; i < 60; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}