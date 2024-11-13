//HO SHAU THONG
//9B240002A
//BoS24-A1
//31 Oct 2024
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

public class BTPR1003_2024C_Assignment1_9B240002A{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int num = input.nextInt();
        String name = "";
        double score = 0;
        String highestName = "";
        double highestScore = 0;
        String lowestName = "";
        double lowestScore = 100;
        for(int i = 0; i < num; i++){
            System.out.print("Enter a student name: ");
            name = input.next();
            System.out.print("Enter a student score: ");
            score = input.nextDouble();
            if(score > highestScore){
                highestScore = score;
                highestName = name;
            }
            if(score < lowestScore){
                lowestScore = score;
                lowestName = name;
            }
        }
        System.out.println("The name of the student with highest score: " + highestName + "'s score is " + highestScore + ".");
        System.out.println("The name of the student with lowest score: " + lowestName + "'s score is " + lowestScore + ".");
    }
}
