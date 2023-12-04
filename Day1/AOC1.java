import java.util.*;
import java.io.*;


public class AOC1 {
	public static void main (String[] args) throws FileNotFoundException {
		Scanner input1 = new Scanner(new File("aoc1.txt"));
		Scanner input2 = new Scanner(new File("aoc1.txt"));
		String[] starr = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		p1(input1);
		p2(input2, starr);
	}
	
	public static void p1(Scanner input) {
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
		System.out.println("part1: " + temp);
	}
	
	public static void p2(Scanner input, String[] arr) {
		int res = 0;
		String fir = "";
		String sec = "";
		int fw;
		int sw;
		while(input.hasNextLine()) {
			String line = input.nextLine();
			sw = -1;
			fw = line.length();
			fir = sec = "";
			for(int i = 0; i < arr.length; i++) {
				if(line.contains(arr[i])){
					if(line.indexOf(arr[i]) != line.lastIndexOf(arr[i])) {
						if(line.indexOf(arr[i]) < fw) {
							fw = line.indexOf(arr[i]);
							if(i < 9) {
								fir = arr[i+9];
							}else {
								fir = arr[i];
							}
						}
						if(line.lastIndexOf(arr[i]) > sw) {
							sw = line.lastIndexOf(arr[i]);
							if(i < 9) {
								sec = arr[i+9];
							}
							else {
								sec = arr[i];
							}
						}
					}
					else {
						if(line.indexOf(arr[i]) < fw) {
							fw = line.indexOf(arr[i]);
							if(i < 9) {
								fir = arr[i+9];
							}else {
								fir = arr[i];
							}
						}
						if(line.indexOf(arr[i]) > sw) {
							sw = line.indexOf(arr[i]);
							if(i < 9) {
								sec = arr[i+9];
							}
							else {
								sec = arr[i];
							}
						}
					}
				}
			}
			res += Integer.parseInt(fir + sec);
		}
		System.out.println("part2: " + res);
	}
}
