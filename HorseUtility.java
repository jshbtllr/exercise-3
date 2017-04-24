package horsehandler;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class HorseUtility {
	public static Integer integerCheck(Integer lowerLimit) {
		Scanner userInput = new Scanner(System.in);
		Integer output;
		
		while(true) {
			try {
				output = Integer.parseInt(userInput.nextLine());
				if (output.intValue() >= lowerLimit) {
					break;
				} else {
					System.out.print("Number provided invalid. Input should be greater than " + (lowerLimit-1) + ": ");
				}
			} catch (NumberFormatException nfe) {
				System.out.print("Input not a number. Provide a new number: ");
			}
		}
		
		return output;
	}

	public static Integer integerCheck(Integer lowerLimit, Integer upperLimit) {
		Scanner userInput = new Scanner(System.in);
		Integer output;

		while (true) {
			try {
				output = Integer.parseInt(userInput.nextLine());
				if ((output >= lowerLimit) && (output <= upperLimit)) {
					break;
				} else if (output < lowerLimit) {
					System.out.print("Number provided is invalid. Input should be greater than " + (lowerLimit-1) + ": ");
				} else {
					System.out.print("There can only be 20 horse participating each race. Specify a new number of participants: ");
				}
			} catch (NumberFormatException nfe) {
				System.out.print("Input not a number. Provide a new number: ");
			}
		}
		return output;
	}
	
	public static Integer moveHorse(Integer input) {
		Integer limit = input.intValue() < 10 ? input.intValue() : 0;
		Random number = new Random();
		Integer generated = number.nextInt(10 - limit) + 1;
		return generated;
	}	
	
	public static Integer boostHorse(Integer input) {
		Random number = new Random();
		Integer limit = input.intValue() < 10 ? input.intValue() : 0;
		
		Integer generated = number.nextInt(20 - limit) + 1;
		return generated;
	}
	
	public static Integer randomInteger(Integer limit) {
		Random number = new Random();
		return number.nextInt(limit);
	}
}
