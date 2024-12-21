//HO SHAU THONG
//9B240002A
//BoS24-A1
//20 Dec 2024
/*(Using arrays) Write a program that reads the integers between 1 and 100 and counts the occurrences of each. 
Assume the input ends with 0. Here is a sample run of the program: 
Enter the integers between 1 and 100: 23 24 1 2 3 1 2 3 5 6 34 24 24 90 0 

1 occurs 2 times 
2 occurs 2 times 
3 occurs 2 times 
5 occurs 1 time 
6 occurs 1 time 
23 occurs 1 time 
24 occurs 3 times 
34 occurs 1 time 
90 occurs 1 time */

import java.util.Scanner;

public class BTPR1003_2024C_Assignment5_9B240002A {
    public static void main(String[] args){
        //create scanner object
        Scanner input = new Scanner(System.in);
        
        //declare variables
        int[] numbers = new int[100];
        int number = 0;
        int count = 0;
        int i = 0;
        
        //prompt user to enter integers between 1 and 100
        System.out.print("Enter the integers between 1 and 100: ");
        number = input.nextInt();
        
        //store the numbers in an array
        while (number != 0){
            numbers[i] = number;
            i++;
            number = input.nextInt();
        }
        
        //count the occurrences of each number
        for (int j = 1; j <= 100; j++){
            count = 0;
            for (int k = 0; k < i; k++){
                if (numbers[k] == j){
                    count++;
                }
            }
            if (count > 0){
                System.out.println(j + " occurs " + count + " times");
            }
        }
    }
}
