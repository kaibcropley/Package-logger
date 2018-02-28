/*
 *   ////////////////////////////////////////
 *   ////Add name and project stuff/date////
 *   //////////////////////////////////////
 *   
 *   Driver
 *   A system to help a business such as a UPS store,
 *   USPS P.O. boxes and small businesses keep track of
 *   customers boxes and receiving packages.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		//Variables
		boolean exit = false;
		Scanner input = new Scanner(System.in);
		String userInput = "";
		
		//Menu for user
		while (!exit) {
			System.out.println("\nPlease type number of what you would like to do?\n"
					+ "1: Create account\n"
					+ "2: See all accounts\n"
					+ "3: Add package\n"
					+ "4: See all packages\n"
					+ "0: Exit");
			userInput = input.next();
			if (userInput.equals("1")) {
				createAccount(input);
			} else if (userInput.equals("2")) {
				printAccounts();
			} else if (userInput.equals("3")) {
				createPackage(input);
			} else if (userInput.equals("4")) {
				printPackages();
			} else if (userInput.equals("0")) {
				exit = true;
			}
		}
		input.close();
	}
	
	//Allows a user to create new accounts through the console
	public static void createAccount(Scanner input) {
		//Variables
		String name;
		String boxNum = "";
//////////////////////////////////////
/////////Change File name/////////////
//////////////////////////////////////
		File accountsFile = new File("C:\\Users\\kaibc\\Documents\\Programming\\Isaac\\Accounts");
		
		//Getting the users input
		System.out.print("Box holders name: ");
		name = input.next();
		
		//While loop to ensure box number is 3 digit number
		while (boxNum.length() != 3) {
			System.out.print("Box number: ");
			boxNum = input.next();
		}	
		
		Account account = new Account(name, boxNum);
		account.addAccountToFile(accountsFile);
	}	
	
	//Prints all accounts currently in the Accounts file
	public static void printAccounts(){
//////////////////////////////////////
/////////Change File name/////////////
//////////////////////////////////////
		File accountsFile = new File("C:\\Users\\kaibc\\Documents\\Programming\\Isaac\\Accounts");
		try {
			Scanner input = new Scanner(accountsFile);
			//Header
			System.out.printf("Name    |Box num \n"
					+ "--------|--------\n");
			
			//Printing data
			printData(input);
			input.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Accounts File not found");
			e.printStackTrace();
		}
	}
	
	public static void createPackage(Scanner input) {
		//Variables
		String trackingNum;
		String boxNum = "";
//////////////////////////////////////
/////////Change File name/////////////
//////////////////////////////////////
		File packagesFile = new File("C:\\Users\\kaibc\\Documents\\Programming\\Isaac\\Packages");
		
		//Getting the users input
		System.out.print("Tracking number: ");
		trackingNum = input.next();
		
		//While loop to ensure box number is 3 digit number
		while (boxNum.length() != 3) {
			System.out.print("Box number: ");
			boxNum = input.next();
		}
		
		Package pack = new Package(boxNum, trackingNum);
		pack.addPackageToFile(packagesFile);
	}
	
	//Prints all accounts currently in the Packages file
	public static void printPackages(){
//////////////////////////////////////
/////////Change File name/////////////
//////////////////////////////////////
		File packagesFile = new File("C:\\Users\\kaibc\\Documents\\Programming\\Isaac\\Packages");
		try {
			Scanner input = new Scanner(packagesFile);
			//Header
			System.out.printf("Box num |Tracking num\n"
					+ "--------|------------\n");
			
			//Printing data
			printData(input);
			input.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Packages File not found");
			e.printStackTrace();
		}
	}
	
	//Used in printing accounts and tracking numbers
	private static void printData(Scanner input) {
		while (input.hasNext()) {
			System.out.printf("%-8s|%-8s\n", input.next(), input.next());
		}
	}
}
