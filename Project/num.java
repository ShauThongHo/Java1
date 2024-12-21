import java.util.*;

public class num4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        boolean quitGame = false;
        int level = 0;
        int[] timeRank = new int[5];
        int[] levelRank = new int[5]; // Difficulty rank for each player
        int[] attemptsRank = new int[5]; // Number of attempts for each player
        String[] nameRank = new String[5];
        String name = "";
        int time = 0;
        int attempts = 0;

        Arrays.fill(timeRank, Integer.MAX_VALUE); // Initialize leaderboard with maximum values

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
                    System.out.println("1. Easy (4 digits)");
                    System.out.println("2. Medium (6 digits)");
                    System.out.println("3. Hard (8 digits)");
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
                        continue; // Re-select difficulty
                    }

                    String[] winnerData = playGame(level);
                    name = winnerData[0];
                    time = Integer.parseInt(winnerData[1]);
                    attempts = Integer.parseInt(winnerData[2]);

                    // Set difficulty weight
                    int levelWeight = 0;
                    if (level == 4) {
                        levelWeight = 1; // Easy
                    } else if (level == 6) {
                        levelWeight = 2; // Medium
                    } else if (level == 8) {
                        levelWeight = 3; // Hard
                    }

                    // Update leaderboard based on time, difficulty, and attempts
                    updateRank(nameRank, timeRank, levelRank, attemptsRank, name, time, levelWeight, attempts);
                    quitGame = backMenu();
                } while (userInput != 1 && userInput != 2 && userInput != 3);
            } else if (userInput == 2) {
                rule();
            } else if (userInput == 3) {
                rank(nameRank, timeRank, levelRank, attemptsRank);
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
        String[] history = new String[100];
        Arrays.fill(history, "    ");
        String userGuess = "";
        int count = 0;
        int[] randomNum = new int[level];
        int[] correctNumbers = new int[100];
        int[] correctPositions = new int[100];
        int[] guessNum = new int[level];
        int userGuessLength = 0;
        int[] temp = new int[level];
        String name = "";
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        int changes = 0;
        boolean value = true;

        // Generate random numbers
        for (int i = 0; i < level; i++) {
            randomNum[i] = (int) (Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if (randomNum[i] == randomNum[j]) {
                    i--;
                    break;
                }
            }
        }

        System.out.println("Welcome to the game!");
        System.out.println("The game has generated " + level + " random numbers between 0 to 9.");
        while (value) {
            System.out.print("Please enter the changes that you want to try(below 100):");
            changes = input.nextInt();
            if (changes > 100 || changes < 1) {
                System.out.println("Invalid input, please try again.");
            } else {
                value = false;
            }
        }
        System.out.println("You have " + changes + " chances to guess the number.");
        // test
        System.out.println("The correct number is: " + Arrays.toString(randomNum));

        for (int i = 1; i <= changes; i++, count++) {
            devider();
            // Print historical guesses
            for (int j = 0; j < changes; j++) {
                System.out.printf("%d. %s %d Correct Numbers %d Correct Positions\n", j + 1, history[j],
                        correctNumbers[j], correctPositions[j]);
            }

            devider();
            System.out.print("Please enter your " + level + " guess number:");
            userGuess = input.next();
            userGuessLength = userGuess.length();
            if (userGuessLength > level || userGuessLength < level) {
                devider();
                System.out.println("Invalid input, please try again.");
                i--;
                count--;
                continue;
            }
            history[count] = userGuess;

            // Convert user's guess to array
            for (int k = level - 1; k >= 0; k--) {
                guessNum[k] = userGuess.charAt(k) - '0';
            }

            // Save original random numbers
            for (int p = 0; p < level; p++) {
                temp[p] = randomNum[p];
            }

            // Check if the user has won
            for (int k = 0; k < level; k++) {
                if (randomNum[k] == guessNum[k]) {
                    correctPositions[count]++;
                }
                for (int l = 0; l < level; l++) {
                    if (randomNum[l] == guessNum[k]) {
                        correctNumbers[count]++;
                        randomNum[l] = -1;
                    }
                }
                if (correctPositions[count] == level) {
                    System.out.println("Congratulations! You win the game!");
                    System.out.print("Please enter your name: ");
                    name = input.next();
                    endTime = System.currentTimeMillis();
                    String time = String.valueOf((endTime - startTime) / 1000);
                    return new String[] { name, time, String.valueOf(i) };
                }
            }
            // Restore random numbers
            for (int p = 0; p < level; p++) {
                randomNum[p] = temp[p];
            }
        }
        for (int j = 0; j < 10; j++) {
            System.out.printf("%d. %s %d Correct Numbers %d Correct Positions\n", j + 1, history[j], correctNumbers[j],
                    correctPositions[j]);
        }
        devider();
        System.out.println("Sorry! You lose the game!");
        System.out.println("The correct number is: " + Arrays.toString(randomNum));
        return new String[] { "", "0", "0" };
    }

    public static void rule() {
        System.out.println("Rules of the Game:");
        System.out.println("1. The game will generate a set of random numbers between 0 and 9.");
        System.out.println("2. You will be given a certain number of attempts to guess the correct sequence.");
        System.out.println("3. After each guess, you will receive feedback in the form of two values:");
        System.out.println("   - 'Correct Numbers' represents how many numbers are correct but in the wrong position.");
        System.out
                .println("   - 'Correct Positions' represents how many numbers are correct and in the right position.");
        System.out.println("4. You need to guess the correct sequence of numbers within 10 attempts.");
        System.out.println("5. If you guess all the numbers correctly and in the correct order, you win the game!");
        System.out.println(
                "6. The game includes three difficulty levels: Easy (4 numbers), Medium (6 numbers), and Hard (8 numbers).");
        System.out.println("   - Easy: Lower difficulty with 4 numbers to guess.");
        System.out.println("   - Medium: Moderate difficulty with 6 numbers to guess.");
        System.out.println("   - Hard: Higher difficulty with 8 numbers to guess.");
        System.out.println(
                "7. The leaderboard ranks players based on time taken to guess the sequence, as well as difficulty level.");
        System.out.println("   - Faster players and those playing at higher difficulty levels will rank higher.");
        System.out.println("8. If you fail to guess the sequence within the allowed attempts, you lose the game.");
    }
    public static void rank(String[] name, int[] time, int[] level, int[] attempts) {
        devider();
        System.out.println("Rank of the game by difficulty, time, and attempts:");
        for (int i = 0; i < 5; i++) {
            if (name[i] != null) {
                System.out.println((i + 1) + ". " + (name[i] == null ? "No player" : name[i]) + " Time: " + time[i]
                        + "s Difficulty: " + level[i] + " Attempts: " + attempts[i]);
            }
        }
    }

    public static void updateRank(String[] nameRank, int[] timeRank, int[] levelRank, int[] attemptsRank, String name, int time,
            int levelWeight, int attempts) {
        double totalScore = time / levelWeight; // Combine time with difficulty: higher difficulty adds more to the score

        for (int i = 0; i < 5; i++) {
            if (totalScore < timeRank[i]) {
                // Move the lower ranks down
                for (int j = 4; j > i; j--) {
                    timeRank[j] = timeRank[j - 1];
                    nameRank[j] = nameRank[j - 1];
                    levelRank[j] = levelRank[j - 1];
                    attemptsRank[j] = attemptsRank[j - 1];
                }
                // Insert new rank
                timeRank[i] = time;
                nameRank[i] = name;
                levelRank[i] = levelWeight;
                attemptsRank[i] = attempts;
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