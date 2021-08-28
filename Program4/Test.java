package Program4;
import java.util.Scanner;

public class Test {

	public static final String delimiter = " "; 
	
	public static void main(String[] args) {
		// Header Info
		System.out.println("Programming Fundamentals");
		System.out.println("NAME: Seth Howells"); 
		System.out.println("PROGRAMMING ASSIGNMENT 4 - SET");
		System.out.println();
		
		Scanner scanner = new Scanner(System.in); // Create Scanner object
		Set set = new Set(); // Create Set object
		
		
		try {
			String inputCommand;
			int inputValue;
			
			// Infinite loop, prompt user to enter Command
			while (true) {
				System.out.print("Enter command: ");
				String userInput = scanner.nextLine();
				
				try {
					// Split user input command into command and value, space delimiter
					inputCommand = userInput.split(delimiter)[0].toLowerCase();
					inputValue = Integer.parseInt(userInput.split(delimiter)[1]); 
				} catch (NumberFormatException e) {
					System.out.println("Input Error. Enter: <command><space><number>");
					System.out.println("Commands: add, del, exists");
					continue;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Input Error. Enter: <command><space><number>");
					System.out.println("Commands: add, del, exists");
					continue;
				}
				
				// Implement switch-case for Commands referencing respective "set" method
				switch (inputCommand) {
				case "add":
					set.add(inputValue);
					System.out.println(set);
					break;
				case "del":
					set.delete(inputValue);
					System.out.println(set);
					break;
				case "exists":
					System.out.println(set.exists(inputValue));
					break;
				default:
					System.out.println("Input Error. Enter: <command><space><number>");
					System.out.println("Commands: add, del, exists");
				}
			}
		} finally {
			scanner.close(); // close scanner
		}
	}
}