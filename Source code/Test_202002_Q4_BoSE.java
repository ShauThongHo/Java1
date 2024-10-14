import java.util.Scanner;

public class Test_202002_Q4_BoSE {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter the first number
    System.out.print("Enter an integer (-1 ends the input): ");
    int value = input.nextInt();
    if (value == -1) {
      System.out.println("No numbers are entered except -1");
      System.exit(1);
    } 
    
    int max = value;
    int count = 1;
    
    while (value != -1) {
      // Prompt the user to enter the remaining numbers
      System.out.print("Enter an integer (-1 ends the input): ");
      value = input.nextInt();

      if (value > max) {
        max = value;
        count = 1;
      } 
      else if (value == max) {
        count++;
      }
    }

    System.out.println("The largest number is " + max);
    System.out.println("The count for the largest number is " + count);
  }
}
