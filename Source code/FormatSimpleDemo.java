public class FormatSimpleDemo { 
  public static void main(String[] args) { 
    long n = 867231;
      System.out.printf("%d\n", n);      //  -->  "461012"
      System.out.printf("%9d\n", n);      //  -->  "   461012"
      System.out.printf("%09d\n", n);    //  -->  "00461012"
      System.out.printf("%+9d\n", n);    //  -->  " +461012"
      System.out.printf("%,9d\n", n);    // -->  " 461,012"
      System.out.printf("%+,9d\n\n", n); //  -->  "+461,012"
      
      double pi = Math.PI;

      System.out.printf("%f\n", pi);       // -->  "3.141593"
      System.out.printf("%.3f\n", pi);     // -->  "3.142"
      System.out.printf("%10.3f\n", pi);   // -->  "     3.142"
      System.out.printf("%-10.3f\n", pi);  // -->  "3.142"

  }
}