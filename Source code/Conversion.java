public class Conversion {
	public static void main(String[] args){
	
		// convert integer and double to string
		int i = 10;
		double j = 10.23;
		
		String s1 = Integer.toString(i);
		String s2 = Double.toString(j);
		String resultString = s1 + s2;
		
		System.out.println("i = " + s1 + "  j = " + s2);
		System.out.println("String result = " + resultString);
		
		//convert string to integer and double
		
		String s3 = "12345";
		String s4 = "12345.67";
		
		int intValue = Integer.parseInt(s3);
		double doubleValue = Double.parseDouble(s4);
		double result = intValue + doubleValue;
		
		System.out.println("intValue (s3) = " + intValue + "  doubleValue (s4) = " + doubleValue);
		System.out.println("result = " + result);
	}
}