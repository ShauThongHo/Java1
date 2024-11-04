//HO SHAU THONG
//9B240002A
//BoS24-A1
//31 Oct 2024
/*Write a program that prompts the user to enter the distance to drive, the fuel efficiency of the car in miles per gallon, and the price per gallon, then displays the cost of the trip.  Here is a sample run: 

Enter the driving distance: 900.5 

Enter miles per gallon: 25.5 

Enter price per gallon: 3.55 

The cost of driving is RM125.36 */

import java.util.Scanner;

public class BTPR1003_2024C_Assignment1_9B240002A{
    public static void main(String[] args){
        //Create a Scanner object
        Scanner input = new Scanner(System.in);

        //Declare variables
        Double drivingDistance = 0.0;
        Double milesPerGallon = 0.0;
        Double pricePerGallon = 0.0;
        Double costOfDriving = 0.0;

        //Prompt the user to enter the driving distance
        System.out.print("Enter the driving distance:");
        drivingDistance = input.nextDouble();

        //Prompt the user to enter the miles per gallon
        System.out.print("Enter miles per gallon:");
        milesPerGallon = input.nextDouble();

        //Prompt the user to enter the price per gallon
        System.out.print("Enter price per gallon:");
        pricePerGallon = input.nextDouble();

        //Calculate the cost of driving
        costOfDriving = (drivingDistance / milesPerGallon) * pricePerGallon;
        
        //Round the cost of driving to 2 decimal places
        costOfDriving = Math.round(costOfDriving * 100.0) / 100.0;

        //Display the cost of driving
        System.out.println("The cost of driving is RM" + costOfDriving);
    }
}