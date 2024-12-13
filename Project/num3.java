import java.util.*;

public class num3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        boolean quitGame = false;
        int level = 0;
        int[] timeRank = new int[5];
        int[] levelRank = new int[5];  // 为每个玩家记录难度的权重
        String[] nameRank = new String[5];
        String name = "";
        int time = 0;

        Arrays.fill(timeRank, Integer.MAX_VALUE);  // 初始化排行榜为空值（最大值）

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
                        continue;  // 重新选择难度
                    }

                    String[] winnerData = playGame(level);
                    name = winnerData[0];
                    time = Integer.parseInt(winnerData[1]);

                    // 为不同难度设置权重
                    int levelWeight = 0;
                    if (level == 4) {
                        levelWeight = 1;  // Easy
                    } else if (level == 6) {
                        levelWeight = 2;  // Medium
                    } else if (level == 8) {
                        levelWeight = 3;  // Hard
                    }

                    // 插入到排行榜
                    updateRank(nameRank, timeRank, levelRank, name, time, levelWeight);
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

        // 生成随机数
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
        System.out.println("You have 10 chances to guess the number.");
        //test
        System.out.println("The correct number is: " + Arrays.toString(randomNum));

        for (int i = 1; i <= 10; i++, count++) {
            devider();
            // 打印历史记录
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

            // 将用户猜测的数字转为数组
            for (int k = level - 1; k >= 0; k--) {
                guessNum[k] = userGuest.charAt(k) - '0';
            }

            // 保存原始的随机数
            for (int p = 0; p < level; p++) {
                temp[p] = randomNum[p];
            }

            // 检查是否中奖
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
            // 恢复随机数
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

    public static void updateRank(String[] nameRank, int[] timeRank, int[] levelRank, String name, int time, int levelWeight) {
        // 计算总排名时间，时间 * 权重
        int totalTime = time * levelWeight;
        
        for (int i = 0; i < 5; i++) {
            if (totalTime < timeRank[i]) {
                // 让后面的排名往后移动
                for (int j = 4; j > i; j--) {
                    timeRank[j] = timeRank[j - 1];
                    nameRank[j] = nameRank[j - 1];
                    levelRank[j] = levelRank[j - 1];
                }
                // 插入新成绩
                timeRank[i] = totalTime;
                nameRank[i] = name;
                levelRank[i] = levelWeight;
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
