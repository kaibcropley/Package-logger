/*
 *   ////////////////////////////////////////
 *   ////Add name and project stuff/date////
 *   //////////////////////////////////////
 *   
 *   Creates an account to hold holders name and box number
 *   Adds each new account to a text file for data storage
 */

import java.io.File;

public class Account extends TextPrintable {
	private String name;
	private String boxNum;
	
	//Constructor
	public Account(String name, String boxNum) {
		this.name = name;
		this.boxNum = boxNum;
		
		System.out.println("Account has been created");
	}
	
	//Returns box holders name
	public String getName() {
		return name;
	}
	
	//Returns box number
	public String getBoxNum() {
		return boxNum;
	}
	
	//Adding the account to a text file
	public void addAccountToFile(File accountsFile) {
		//Getting old data from text file
		String data = this.getOldData(accountsFile);	
		//Adding in our new account
		data += (name + " " + boxNum);
		//Adding all data back into file
		this.writeToFile(accountsFile, data);
	}
}
