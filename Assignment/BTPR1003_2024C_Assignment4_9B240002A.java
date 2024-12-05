//HO SHAU THONG
//9B240002A
//BoS24-A1
//7 Dec 2024
/*Write a method that computes the sum of the digits in an integer. 
Use the following method header: 
public static int sumDigits(int n) 

Write a test program that prompts the user to enter an integer then displays the sum of all its digits. 

For example, sumDigits(234) returns 9 (= 2 + 3 + 4). */

import java.util.Scanner;

public class BTPR1003_2024C_Assignment4_9B240002A {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        //declare variables
        int number = 0; //number
        int temp = 0; //temporary variable
        String message = ""; //message to display the sum of all digits
        int n = 0; //variable to store the number

        //prompt user to enter a number
        System.out.print("Enter a number: ");
        number = input.nextInt();

        //store the number in n
        n = number;
        while (n != 0) {
            temp = n % 10; 
            message += temp + " + ";
            n /= 10; 
        }

        //display the sum of all digits
        System.out.println("The sum of all digits is: " + sumDigits(number) + " (= " + message.substring(0, message.length() - 3) + ")");
        
    }

    // Method to compute the sum of the digits in an integer
    public static int sumDigits(int n) {
        int sum = 0;
        int temp = 0;

        while (n != 0) {
            temp = n % 10; //get the last digit
            sum += temp; //add the last digit to sum
            n /= 10; //remove the last digit
        }
        return sum;
    }
}
