import java.util.*;
import java.io.*;

public class AOC1 {
	public static void main (String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("aoc1.txt"));
		helper(input);
	}
	
	public static void helper(Scanner input) {
		String s = "";
		int temp = 0;
		while(input.hasNextLine()) {
			String line = input.nextLine();
			for (char ch : line.toCharArray()) {
	            if (Character.isDigit(ch)) {
	            	if(s == "") {
	            		s = Character.toString(ch) + Character.toString(ch);
	            	}
	            	else {
	            		s = s.charAt(0) + Character.toString(ch);
	            	}
	            }
	        }
			temp += Integer.parseInt(s);
			s = "";
		}
		System.out.println(temp);
	}
}
