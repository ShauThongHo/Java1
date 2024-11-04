//HO SHAU THONG
//9B240002A
//BoS24-A1
//04 Now 2024
/*A shipping company uses the following function to calculate the cost (in Ringgit Malaysia) of shipping based on the cost of weight (in kilograms) multiply weight and plus a fixed cost RM20.00. 

                    12.00, if 0 < w <= 1 
                    22.00, if 1 < w <= 3 
Cost of weight =    34.00, if 3 < w <= 10 
                    42.00, if 10 < w <= 20                             

Write a program that prompts the user to enter the weight of the package and displays the shipping cost. 
If the weight is negative or zero, display a message “Invalid input.” 
If the weight is greater than 20, display a message “The package cannot be shipped.” Here is a sample run: 

Enter package weight: 0 
Invalid input. 

Enter package weight: 15 
The shipping cost is RM650.00 

Enter package weight: 21 
The package cannot be shipped */

import java.util.Scanner;

public class BTPR1003_2024C_Assignment2_9B240002A {
    public void main(String[] args){
        //Create a Scanner object
        Scanner input = new Scanner(System.in);

        //Deviation
        int weight = 0;
        int shippingCost = 0;

        //Prompt the user to enter the package weight
        System.out.print("Enter package weight:");
        weight = input.nextInt();

        //Check if the weight is negative or zero
        if(weight <= 0){
            System.out.println("Invalid input.");
        }

        //Calculate the shipping cost
        else if(weight > 0 && weight <=1){
            shippingCost = weight *12 + 20;
            System.out.println("The shipping cost is RM" + shippingCost + ".00");
        }
        else if(weight > 1 && weight <=3){
            shippingCost = weight * 22 + 20;
            System.out.println("The shipping cost is RM" + shippingCost + ".00");
        }
        else if(weight > 3 && weight <=10){
            shippingCost = weight * 34 + 20;
            System.out.println("The shipping cost is RM" + shippingCost + ".00");
        }
        else if(weight > 10 && weight <=20){
            shippingCost = weight * 42 + 20;
            System.out.println("The shipping cost is RM" + shippingCost + ".00");
        }

        //Check if the weight is greater than 20
        else{
            System.out.println("The package cannot be shipped");
        }
    }
}
