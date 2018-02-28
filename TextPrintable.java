/*
 *   ////////////////////////////////////////
 *   ////Add name and project stuff/date////
 *   //////////////////////////////////////
 *   
 *   Parent class to get or write data for child classes
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextPrintable {
	
	public TextPrintable() {
		
	}
	
	//Returns data from file as one String
	public String getOldData(File textFile) {
		Scanner input;
		String data = "";
		try {
			input = new Scanner(textFile);
			
			//Getting old accounts
			while (input.hasNextLine()) {
				data += input.nextLine() + "\n";
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return data;
	}
	
	//Writes given data to given file
	public void writeToFile(File textFile, String data){
		PrintWriter writer;
		try {
			writer = new PrintWriter(textFile);
			writer.print(data);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
	}
}
