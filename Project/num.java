import java.util.*;

public class num {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        boolean quitGame = false;
        int level = 0;
        int[] timeRank = new int[5];
        String[] nameRank = new String[5];
        String name = "";
        int time = 0;
        int timeTemp = 0;
        String nameTemp = "";

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
                    if(userInput == 1)
                    level = 4;
                    else if(userInput == 2)
                    level = 6;
                    else if(userInput == 3)
                    level = 8;
                    else
                    {
                        System.out.println("Invalid input, please try again.");
                    }

                        String[] winnerData = playGame(level);
                        name = winnerData[0];
                        time = Integer.parseInt(winnerData[1]);

                        int i = 0;
                        if(time < timeRank[i]){
                            timeTemp = timeRank[i];
                            nameTemp = nameRank[i];
                            timeRank[i] = time;
                            nameRank[i] = name;
                            timeTemp = timeRank[i+1];
                            nameTemp = nameRank[i+1];
                            timeRank[i+1] = timeTemp;
                            nameRank[i+1] = nameTemp;
                            timeTemp = timeRank[i+2];
                            nameTemp = nameRank[i+2];
                            timeRank[i+2] = timeTemp;
                            nameRank[i+2] = nameTemp;
                            timeTemp = timeRank[i+3];
                            nameTemp = nameRank[i+3];
                            timeRank[i+3] = timeTemp;
                            nameRank[i+3] = nameTemp;
                            timeRank[i+4] = timeTemp;
                            nameRank[i+4] = nameTemp;

                        }
                        else if(time < timeRank[i]+1)
                        {
                            timeTemp = timeRank[i+1];
                            nameTemp = nameRank[i+1];
                            timeRank[i+1] = time;
                            nameRank[i+1] = name;
                            timeTemp = timeRank[i+2];
                            nameTemp = nameRank[i+2];
                            timeRank[i+2] = timeTemp;
                            nameRank[i+2] = nameTemp;
                            timeTemp = timeRank[i+3];
                            nameTemp = nameRank[i+3];
                            timeRank[i+3] = timeTemp;
                            nameRank[i+3] = nameTemp;
                            timeRank[i+4] = timeTemp;
                            nameRank[i+4] = nameTemp;
                        }
                        else if(time < timeRank[i]+2)
                        {
                            timeTemp = timeRank[i+2];
                            nameTemp = nameRank[i+2];
                            timeRank[i+2] = time;
                            nameRank[i+2] = name;
                            timeTemp = timeRank[i+3];
                            nameTemp = nameRank[i+3];
                            timeRank[i+3] = timeTemp;
                            nameRank[i+3] = nameTemp;
                            timeRank[i+4] = timeTemp;
                            nameRank[i+4] = nameTemp;
                        }
                        else if(time < timeRank[i]+3)
                        {
                            timeTemp = timeRank[i+3];
                            nameTemp = nameRank[i+3];
                            timeRank[i+3] = time;
                            nameRank[i+3] = name;
                            timeRank[i+4] = timeTemp;
                            nameRank[i+4] = nameTemp;
                        }
                        else if(time < timeRank[i]+4)
                        {
                            timeRank[i+4] = time;
                            nameRank[i+4] = name;
                        }
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
        String[] history = { "    ", "    ", "    ", "    ", "    ", "    ", "    ", "    ", "    ", "    " };
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
        String time = 0;
        long endTime = 0;

        for (int i = 0; i < level; i++) {
            randomNum[i] = (int) (Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if (randomNum[i] == randomNum[j]) {
                    i--;
                    break;
                }
            }
        }

        for (int i = 0; i < level; i++) {
            System.out.print(randomNum[i]);
        }

        System.out.println("Welcome to the game!");
        System.out.println("The game has generated" + level + "random number between 0 to 9.");
        System.out.println("You have 10 chances to guess the number.");

        for (int i = 1; i <= 10; i++, count++) {
            devider();
            for (int j = 0; j < 10; j++) {
                if (level == 4)
                    System.out.printf("%d. %s %dA %dB\n", j + 1, history[j], a[j], b[j]);
                else if (level == 6)
                    System.out.printf("%d. %s %dA %dB\n", j + 1, history[j], a[j], b[j]);
                else if (level == 8)
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

            for (int k = level - 1; k >= 0; k--) {
                guessNum[k] = userGuest.charAt(k) - '0';
            }

            for (int p = 0; p < level; p++)
                temp[p] = randomNum[p];
            // check winner
            for (int k = 0; k < level; k++) {// guessNum
                if (randomNum[k] == guessNum[k]) {
                    b[count]++;
                }
                for (int l = 0; l < level; l++) {// randomNum
                    if (randomNum[l] == guessNum[k]) {
                        a[count]++;
                        randomNum[l] = -1;

                    }
                }
                if (b[count] == level) {
                    System.out.println("Congratulations! You win the game!");
                    System.out.print("Please enter your name:");
                    name = input.next();
                    endTime = System.currentTimeMillis();
                    time = String.valueOf((endTime - startTime) / 1000);
                    String message = name + " " + time;
                    return new String[] { name, time };
                }
            }
            for (int p = 0; p < level; p++)
                randomNum[p] = temp[p];
        }
        devider();
        for (int j = 0; j < 10; j++) {
            if (level == 4)
                System.out.printf("%d. %s %dA %dB\n", j + 1, history[j], a[j], b[j]);
            else if (level == 6)
                System.out.printf("%d. %s %dA %dB\n", j + 1, history[j], a[j], b[j]);
            else if (level == 8)
                System.out.printf("%d. %s %dA %dB\n", j + 1, history[j], a[j], b[j]);
        }
        devider();
        System.out.println("Sorry! You lose the game!");
        System.out.println("The correct number is:" + randomNum[0] + randomNum[1] + randomNum[2] + randomNum[3]);
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
        System.out.println("1. Player 1: 10 points");
        System.out.println("2. Player 2: 9 points");
        System.out.println("3. Player 3: 8 points");
        System.out.println("4. Player 4: 7 points");
        System.out.println("5. Player 5: 6 points");
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

    public static void devider() {
        for (int i = 0; i < 60; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
