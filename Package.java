import java.io.File;

/*
 *   ////////////////////////////////////////
 *   ////Add name and project stuff/date////
 *   //////////////////////////////////////
 *   
 *   Used to create package objects
 */

public class Package extends TextPrintable  {
	private String trackingNum;
	private String boxNum;
	
	//Constructor
	public Package(String boxNum, String trackingNum) {
		this.boxNum = boxNum;
		this.trackingNum = trackingNum;
	}
	
	//Returns box number
	public String getBoxNum() {
		return boxNum;
	}
	
	//Returns tracking number
	public String getTrackingNum() {
		return trackingNum;
	}
	
	public void addPackageToFile(File packagesFile) {
		//Getting old data from text file
		String data = this.getOldData(packagesFile);	
		//Adding in our new account
		data += (boxNum + " " + trackingNum);
		//Adding all data back into file
		this.writeToFile(packagesFile, data);
	}
}
