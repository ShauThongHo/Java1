


//Title: Cinema Seat Booking Program

//Project Objective:
// -Cinema ticket booking system helps the booking process work more efficiently.
// -Easy to use as a threater worker to manage reservation for customer after the payment is made.
// -Convenient and Time-saving 

//Description:
// This is a program that can be used for movie seat booking. Below are the following function:
// a)User are able to buy ticket and select their seat they would like to choose. 
// b)User are able to cancel their booking of the seat by selecting their seat that they have bought.
// c)User can enter the number of seat they would like to book or cancel.
// d)The program will display the seat is taken when user select a taken seat.
// e)The program will display the seat is empty when user cancel a empty seat.
// f)The program can display seat which allows user to check the seat.
// g)The program will return to main menu after the task is completed.
// h)The program is ended when the user choose to quit the program.

//Structure Review:
// This program used knowledge that have learned form Java Programming I including:
// a)'method' to arrange the function of the program
// b)'case' to let user enter their choice and redirect it to its method function 
// c)'if-else' to display output based on condition
// e)'array' to identified the seat
// f)'loop' to repeat the function and return to main menu




import java.util.Scanner;

public class Sample1 {

    public static String A[] = new String[10];
    public static String B[] = new String[10];
    public static String C[] = new String[10];
    public static String D[] = new String[10];
    public static String E[] = new String[10];
    public static String F[] = new String[10];
    public static String G[] = new String[10];
    public static String H[] = new String[10];
    public static String I[] = new String[10];
    public static String J[] = new String[10];
    public static String K[] = new String[10];
    public static Scanner input = new Scanner(System.in);
    

    public static void main(String[] args) {
       
        int choice;
        int quit=0;
        
        for (int a = 1; a <= 9; a++) {
            A[a] = "A";
        }
        for (int a = 1; a <= 9; a++) {
            B[a] = "B";
        }
        for (int a = 1; a <= 9; a++) {
            C[a] = "C";
        }
        for (int a = 1; a <= 9; a++) {
            D[a] = "D";
        }
        for (int a = 1; a <= 9; a++) {
            E[a] = "E";
        }
        for (int a = 1; a <= 9; a++) {
            F[a] = "F";
        }
        for (int a = 1; a <= 9; a++) {
            G[a] = "G";
        }
        for (int a = 1; a <= 9; a++) {
            H[a] = "H";
        }
        for (int a = 1; a <= 9; a++) {
            I[a] = "I";
        }
        for (int a = 1; a <= 9; a++) {
            J[a] = "J";
        }
        for (int a = 1; a <= 9; a++) {
            K[a] = "K";
        }
        
        System.out.println("Welcome To AURA Cinema");
            System.out.println("Best movie experience to you~");
            System.out.print("Please enter your name: ");
            String name = input.nextLine();
            System.out.println("Welcome," + name);

        do {
            
            System.out.println("");
            System.out.println("*****    MAIN MENU   *****");

            System.out.println("[1] Buy Ticket");
            System.out.println("[2] Cancel Ticket");
            System.out.println("[3] Display Seat");
            System.out.println("[4] Exit");

            System.out.print("Please enter your selection: ");
            choice = input.nextInt();
            System.out.println(" ");

            switch (choice) {
                case 1:
                    BUY();
                    break;
                case 2:
                    CANCEL();
                    break;
                case 3:
                    DISPLAY();
                    break;
                case 4:
                    QUIT();
                    quit++;
                    break;
                default: 
                    System.out.println("Something went wrong. Please Try Again >_<");
                
            }
        } while(quit != 1);
        
    }

    public static void BUY() {
        int i = 1;

        System.out.print("Please Enter The Number of Ticket: ");
        int numseat = input.nextInt();

        System.out.println("You may now choose a seat");
        System.out.println(" ROW       				SEAT      ");
        System.out.println("  1 :   |A|B| |C|D|E|F|G|H|I| |J|K|");
        System.out.println("  2 :   |A|B| |C|D|E|F|G|H|I| |J|K|");
        System.out.println("  3 :   |A|B| |C|D|E|F|G|H|I| |J|K|");
        System.out.println("  4 :   |A|B| |C|D|E|F|G|H|I| |J|K|");
        System.out.println("  5 :   |A|B| |C|D|E|F|G|H|I| |J|K|");
        System.out.println("  6 :   |A|B| |C|D|E|F|G|H|I| |J|K|");
        System.out.println("  7 :   |A|B| |C|D|E|F|G|H|I| |J|K|");
        System.out.println("  8 :   |A|B| |C|D|E|F|G|H|I| |J|K|");
        System.out.println("  9 :   |A|B| |C|D|E|F|G|H|I| |J|K|");
        System.out.println("");

        do {
            System.out.print("Please Enter Your Seat Row (1-9): ");
            int seatrow = input.nextInt();
            System.out.print("Please Enter Your Seat (A-K): ");
            String seat = input.next();

            i++;

            if (seatrow <= 9 && seatrow > 0 && "A".equals(seat) || "a".equals(seat)) {
                if (!"A".equals(A[seatrow])) {
                    System.out.println("The seat has been taken");
                } else {
                    A[seatrow] = "X";
                }
            } else if (seatrow <= 9 && seatrow > 0 && "B".equals(seat) || "b".equals(seat)) {
                if (!"B".equals(B[seatrow])) {
                    System.out.print("The seat has been taken");
                } else {
                    B[seatrow] = "X";
                }
            } else if (seatrow <= 9 && seatrow > 0 && "C".equals(seat) || "c".equals(seat)) {
                if (!"C".equals(C[seatrow])) {
                    System.out.print("The seat has been taken");
                } else {
                    C[seatrow] = "X";
                }
            } else if (seatrow <= 9 && seatrow > 0 && "D".equals(seat) || "d".equals(seat)) {
                if (!"D".equals(D[seatrow])) {
                    System.out.print("The seat has been taken");
                } else {
                    D[seatrow] = "X";
                }
            } else if (seatrow <= 9 && seatrow > 0 && "E".equals(seat) || "e".equals(seat)) {
                if (!"E".equals(E[seatrow])) {
                    System.out.print("The seat has been taken");
                } else {
                    E[seatrow] = "X";
                }
            } else if (seatrow <= 9 && seatrow > 0 && "F".equals(seat) || "f".equals(seat)) {
                if (!"F".equals(F[seatrow])) {
                    System.out.print("The seat has been taken");
                } else {
                    F[seatrow] = "X";
                }
            } else if (seatrow <= 9 && seatrow > 0 && "G".equals(seat) || "g".equals(seat)) {
                if (!"G".equals(G[seatrow])) {
                    System.out.print("The seat has been taken");
                } else {
                    G[seatrow] = "X";
                }
            } else if (seatrow <= 9 && seatrow > 0 && "H".equals(seat) || "h".equals(seat)) {
                if (!"H".equals(H[seatrow])) {
                    System.out.print("The seat has been taken");
                } else {
                    H[seatrow] = "X";
                }
            } else if (seatrow <= 9 && seatrow > 0 && "I".equals(seat) || "i".equals(seat)) {
                if (!"I".equals(I[seatrow])) {
                    System.out.print("The seat has been taken");
                } else {
                    I[seatrow] = "X";
                }
            } else if (seatrow <= 9 && seatrow > 0 && "J".equals(seat) || "j".equals(seat)) {
                if (!"J".equals(J[seatrow])) {
                    System.out.print("The seat has been taken");
                } else {
                    J[seatrow] = "X";
                }
            } else if (seatrow <= 9 && seatrow > 0 && "K".equals(seat) || "k".equals(seat)) {
                if (!"K".equals(K[seatrow])) {
                    System.out.print("The seat has been taken");
                } else {
                    K[seatrow] = "X";
                }
            } else {
                System.out.println("Something went wrong. Please Try Again >_<");
            }

        } while (i <= numseat);
        int totalseat = 0;
        totalseat = totalseat + numseat;
        System.out.println("Booking completed,Thanks for choosing AURA!");
        System.out.println("You have booked " + totalseat + " seat.");
        System.out.println("Enjoy your movie! :D");
    }

    public static void CANCEL() {
        int b = 1;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of ticket you want to cancel.");
        int NUMSEAT = input.nextInt();

        System.out.println("You may now choose the seat you would like to cancel.");
        System.out.println(" ");
        System.out.println(" ROW    			SEAT     ");
        System.out.println("  1     |" + A[1] + "|" + B[1] + "|   |" + C[1] + "|" + D[1] + "|" + E[1] + "|" + F[1] + "|" + G[1] + "|" + H[1] + "|" + I[1] + "|   |" + J[1] + "|" + K[1] + "|");
        System.out.println("  2     |" + A[2] + "|" + B[2] + "|   |" + C[2] + "|" + D[2] + "|" + E[2] + "|" + F[2] + "|" + G[2] + "|" + H[2] + "|" + I[2] + "|   |" + J[2] + "|" + K[2] + "|");
        System.out.println("  3     |" + A[3] + "|" + B[3] + "|   |" + C[3] + "|" + D[3] + "|" + E[3] + "|" + F[3] + "|" + G[3] + "|" + H[3] + "|" + I[3] + "|   |" + J[3] + "|" + K[3] + "|");
        System.out.println("  4     |" + A[4] + "|" + B[4] + "|   |" + C[4] + "|" + D[4] + "|" + E[4] + "|" + F[4] + "|" + G[4] + "|" + H[4] + "|" + I[4] + "|   |" + J[4] + "|" + K[4] + "|");
        System.out.println("  5     |" + A[5] + "|" + B[5] + "|   |" + C[5] + "|" + D[5] + "|" + E[5] + "|" + F[5] + "|" + G[5] + "|" + H[5] + "|" + I[5] + "|   |" + J[5] + "|" + K[5] + "|");
        System.out.println("  6     |" + A[6] + "|" + B[6] + "|   |" + C[6] + "|" + D[6] + "|" + E[6] + "|" + F[6] + "|" + G[6] + "|" + H[6] + "|" + I[6] + "|   |" + J[6] + "|" + K[6] + "|");
        System.out.println("  7     |" + A[7] + "|" + B[7] + "|   |" + C[7] + "|" + D[7] + "|" + E[7] + "|" + F[7] + "|" + G[7] + "|" + H[7] + "|" + I[7] + "|   |" + J[7] + "|" + K[7] + "|");
        System.out.println("  8     |" + A[8] + "|" + B[8] + "|   |" + C[8] + "|" + D[8] + "|" + E[8] + "|" + F[8] + "|" + G[8] + "|" + H[8] + "|" + I[8] + "|   |" + J[8] + "|" + K[8] + "|");
        System.out.println("  9     |" + A[9] + "|" + B[9] + "|   |" + C[9] + "|" + D[9] + "|" + E[9] + "|" + F[9] + "|" + G[9] + "|" + H[9] + "|" + I[9] + "|   |" + J[9] + "|" + K[9] + "|");
		System.out.println("");
		
        do {
            System.out.print("Please Enter Your Cancel Seat Row (1-9): ");
            int SEATROW = input.nextInt();
            System.out.print("Please Enter Your Cancel Seat (A-K): ");
            String sseat = input.next();

            if (SEATROW <= 9 && SEATROW > 0 && "A".equals(sseat) || "a".equals(sseat)) {
                if (!"X".equals(A[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    A[SEATROW] = "A";
                    System.out.println("Cancelation completed");
                }
            } else if (SEATROW <= 9 && SEATROW > 0 && "B".equals(sseat) || "b".equals(sseat)) {
                if (!"X".equals(B[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    B[SEATROW] = "B";
                    System.out.println("Cancelation completed");
                }
            } else if (SEATROW <= 9 && SEATROW > 0 && "C".equals(sseat) || "c".equals(sseat)) {
                if (!"X".equals(C[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    C[SEATROW] = "C";
                    System.out.println("Cancelation completed");
                }
            } else if (SEATROW <= 9 && SEATROW > 0 && "D".equals(sseat) || "d".equals(sseat)) {
                if (!"X".equals(D[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    D[SEATROW] = "D";
                    System.out.println("Cancelation completed");
                }

            } else if (SEATROW <= 9 && SEATROW > 0 && "E".equals(sseat) || "e".equals(sseat)) {
                if (!"X".equals(E[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    E[SEATROW] = "E";
                    System.out.println("Cancelation completed");
                }
            } else if (SEATROW <= 9 && SEATROW > 0 && "F".equals(sseat) || "f".equals(sseat)) {
                if (!"X".equals(F[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    F[SEATROW] = "F";
                    System.out.println("Cancelation completed");
                }

            } else if (SEATROW <= 9 && SEATROW > 0 && "G".equals(sseat) || "g".equals(sseat)) {
                if (!"X".equals(G[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    G[SEATROW] = "G";
                    System.out.println("Cancelation completed");
                }

            } else if (SEATROW <= 9 && SEATROW > 0 && "H".equals(sseat) || "h".equals(sseat)) {
                if (!"X".equals(H[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    H[SEATROW] = "H";
                    System.out.println("Cancelation completed");
                }

            } else if (SEATROW <= 9 && SEATROW > 0 && "I".equals(sseat) || "i".equals(sseat)) {
                if (!"X".equals(I[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    I[SEATROW] = "I";
                    System.out.println("Cancelation completed");
                }

            } else if (SEATROW <= 9 && SEATROW > 0 && "J".equals(sseat) || "j".equals(sseat)) {
                if (!"X".equals(J[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    J[SEATROW] = "J";
                    System.out.println("Cancelation completed");
                }

            } else if (SEATROW <= 9 && SEATROW > 0 && "K".equals(sseat) || "k".equals(sseat)) {
                if (!"X".equals(K[SEATROW])) {
                    System.out.println("The seat is empty");
                } else {
                    K[SEATROW] = "K";
                    System.out.println("Cancelation completed");
                }

            } else {
                System.out.println("Something went wrong. Please Try Again >_<");
            }
            b++;
        } while (b <= NUMSEAT);
        int numseat = 0;
        numseat = numseat - NUMSEAT;
    }

    public static void DISPLAY() {

        System.out.println("Displaying Seats:");
        System.out.println(" ROW    			SEAT     ");
        System.out.println("  1     |" + A[1] + "|" + B[1] + "|   |" + C[1] + "|" + D[1] + "|" + E[1] + "|" + F[1] + "|" + G[1] + "|" + H[1] + "|" + I[1] + "|   |" + J[1] + "|" + K[1] + "|");
        System.out.println("  2     |" + A[2] + "|" + B[2] + "|   |" + C[2] + "|" + D[2] + "|" + E[2] + "|" + F[2] + "|" + G[2] + "|" + H[2] + "|" + I[2] + "|   |" + J[2] + "|" + K[2] + "|");
        System.out.println("  3     |" + A[3] + "|" + B[3] + "|   |" + C[3] + "|" + D[3] + "|" + E[3] + "|" + F[3] + "|" + G[3] + "|" + H[3] + "|" + I[3] + "|   |" + J[3] + "|" + K[3] + "|");
        System.out.println("  4     |" + A[4] + "|" + B[4] + "|   |" + C[4] + "|" + D[4] + "|" + E[4] + "|" + F[4] + "|" + G[4] + "|" + H[4] + "|" + I[4] + "|   |" + J[4] + "|" + K[4] + "|");
        System.out.println("  5     |" + A[5] + "|" + B[5] + "|   |" + C[5] + "|" + D[5] + "|" + E[5] + "|" + F[5] + "|" + G[5] + "|" + H[5] + "|" + I[5] + "|   |" + J[5] + "|" + K[5] + "|");
        System.out.println("  6     |" + A[6] + "|" + B[6] + "|   |" + C[6] + "|" + D[6] + "|" + E[6] + "|" + F[6] + "|" + G[6] + "|" + H[6] + "|" + I[6] + "|   |" + J[6] + "|" + K[6] + "|");
        System.out.println("  7     |" + A[7] + "|" + B[7] + "|   |" + C[7] + "|" + D[7] + "|" + E[7] + "|" + F[7] + "|" + G[7] + "|" + H[7] + "|" + I[7] + "|   |" + J[7] + "|" + K[7] + "|");
        System.out.println("  8     |" + A[8] + "|" + B[8] + "|   |" + C[8] + "|" + D[8] + "|" + E[8] + "|" + F[8] + "|" + G[8] + "|" + H[8] + "|" + I[8] + "|   |" + J[8] + "|" + K[8] + "|");
        System.out.println("  9     |" + A[9] + "|" + B[9] + "|   |" + C[9] + "|" + D[9] + "|" + E[9] + "|" + F[9] + "|" + G[9] + "|" + H[9] + "|" + I[9] + "|   |" + J[9] + "|" + K[9] + "|");

    }

    public static void QUIT() {
        Scanner input = new Scanner(System.in);
        String shouldContinue = "Y";
        System.out.println("You are leaving AURA,Do you want to proceed? Y/N");
        shouldContinue = input.next();

        if (shouldContinue.equals("Y") || shouldContinue.equals("y")) {
            System.out.println("*****  THANK YOU FOR CHOOSING AURA  *****");
        }

    }

}
