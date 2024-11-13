//HO SHAU THONG
//9B240002A
//BoS24-A1
//13 Nov 2024
/*Write a program that prompts the user to enter the number of students and each student’s name and score, 
and finally displays the name of the student with the highest and the name of the student with the lowest score. 
Use the next() method in the Scanner class to read a name, rather than using the nextLine() method. Here is a sample run: 

Enter the number of students: 5 
Enter a student name: John 
Enter a student score: 78 
Enter a student name: Peter 
Enter a student score: 45 
Enter a student name: Jocelyn 
Enter a student score: 98 
Enter a student name: Mark 
Enter a student score: 88 
Enter a student name: Moses 
Enter a student score: 99 

The name of the student with highest score: Moses's score is 99.0. 
The name of the student with lowest score: Peter’s score is 45.0.*/

import java.util.Scanner;

public class BTPR1003_2024C_Assignment3_9B240002A{
    public static void main(String[] args){

        //create scanner object
        Scanner input = new Scanner(System.in);

        //declare variables
        int numOfStudent = 0; //number of student
        String studentName = ""; //student name
        double studentScore = 0; //student score
        double highestScore = 0; //highest score
        double lowestScore = 999; //lowest score
        String highestName = ""; //highest name
        String lowestName = ""; //lowest name
        int count = 0; //counter

        //prompt user to enter the number of students
        System.out.print("Enter the number of students: ");
        numOfStudent = input.nextInt();

        //loop to get student name and score
        while(count < numOfStudent){
            System.out.print("Enter a student name: ");
            studentName = input.next();
            System.out.print("Enter a student score: ");
            studentScore = input.nextDouble();

            //check if the student score is higher than the highest score
            if(studentScore > highestScore){
                highestScore = studentScore;
                highestName = studentName;
            }

            //check if the student score is lower than the lowest score
            if(studentScore < lowestScore){
                lowestScore = studentScore;
                lowestName = studentName;
            }
            
            count++; //increment counter
        }

        //display the name of the student with highest and lowest score
        System.out.println("\nThe name of the student with highest score: " + highestName + "'s score is " + highestScore + ".");
        System.out.println("The name of the student with lowest score: " + lowestName + "'s score is " + lowestScore + ".");
    }
}
