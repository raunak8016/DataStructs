//Demonstration of directly converting character to integer based on ASCII value

public class asciiIntDemo{
	public static void main(String[] args){
		char ch1 = 'c';
		int ch1AsInt = ch1;
		System.out.println("ASCII value of " + ch1 + " is " + ch1AsInt);
		//ASCII value of c is 99
		
		
		// Note that you don't necessarily even have to explicitly convert.
		// In the following example, we use the way Java stores characters
		// to add the ASCII value of 'c' to 3 without making an explicit conversion.
		int total = 3;
		total += ch1;
		System.out.println(total); //102
	}
}