package javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random r=new Random();
		int randomcount = r.nextInt(10000);
		return randomcount;		
	}
	
	public String getCurrentDate() {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
		String currentdate = sdf.format(d);
		return currentdate;
	}
	public String togetRequired(int days) {
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
		sdf.format(d);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String daterequired = sdf.format(cal.getTime());
		return daterequired;
	}
	
	
	//----------------------------------
	public String getRandomAlphaNumericString(int length) {
	    // Define the characters that can be used in the random string
	    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    StringBuilder randomString = new StringBuilder();
	    Random random = new Random();

	    // Loop 'length' times to build the string
	    for (int i = 0; i < length; i++) {
	        // Get a random index from the 'characters' string
	        int index = random.nextInt(characters.length());
	        // Append the character at the random index to the StringBuilder
	        randomString.append(characters.charAt(index));
	    }
	    return randomString.toString();
	}
	
	

}
