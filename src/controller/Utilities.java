
package termproj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {

    static int z = 47;
    
    static int getTimeFromShowtime(String showtimeStr) {
	String[] splitStr = showtimeStr.split("\\s+");
	String time = splitStr[1];
	int convertedTime = Utilities.convertTime(time);
	System.out.println("time converted from showtime is: " + convertedTime);
	return convertedTime;
    }
    
    static int convertTime(String timeStr) {
	String[] parts = timeStr.split(":");
	String s = parts[0] + parts[1].substring(0, 2);
	String maybePM = parts[1].substring(2);
	boolean isPm = false;
	if(maybePM.equals("pm")) {
	    isPm = true;
	}
	int time = Integer.parseInt(s);
	if(isPm) {
	    time += 1200;
	}
	return time;
    }

    static String unConvertTime(int time) {
	boolean isPm = false;
	if (time > 1200) {
	    time = time - 1200;
	    isPm = true;
	}
	String time1 = String.valueOf(time);
	String timeStr = time1.substring(0, time1.length()-2) + ":";
	timeStr += time1.substring(time1.length()-2);
	if(isPm) {
	    timeStr += "pm";
	}
	else {
	    timeStr += "am";
	}
	return timeStr;
    }

    static String unConvertTime(String time) {
	return unConvertTime(Integer.parseInt(time));
    }

    static double checkForPromo(String promoName) {
	double promoRate = 0;
	try {
	    String pathName = "promos.txt";
	    File f = new File(pathName);
	    BufferedReader b = new BufferedReader(new FileReader(f));
	    String line = "";
	    while((line = b.readLine()) != null) {
		String[] s = line.split("\\s+");
		if(promoName.equals(s[0])) {
		    System.out.println("Found a promo called: " + promoName);
		    promoRate = Double.parseDouble(s[1]);
		}
	    }
	}
	catch(IOException e) {
	    
	}
	return promoRate;
    }
    
    static String ept(String pass) {
	return pass;
	/*
	String newPass = "";
	for(int i = 0; i < pass.length(); i++) {
	    char character = pass.charAt(i);
	    int ascii = (int) character;
	    int new_ascii = ascii;
	    if(ascii < 80) {
		new_ascii = ascii + 47;
	    }
	    else {
		new_ascii = ascii - 47;
	    }
	    char newCharacter = (char) new_ascii;
	    newPass += newCharacter;
	}
	System.out.println("Password encrypted from " + pass + " to " + newPass);
	return newPass;
	*/
    }

    static String uept(String encrypted) {
	return encrypted;
	/*
	String original = "";
	for(int i = 0; i < encrypted.length(); i++) {
	    char character =  encrypted.charAt(i);
	    int ascii = (int) character;
	    int new_ascii = ascii;
	    if(ascii < 80) {
		new_ascii = ascii + 47;
	    }
	    else {
		new_ascii = ascii - 47;
	    }
	    char newCharacter = (char) new_ascii;
	    original += newCharacter;
	}
	System.out.println("Password unencrypted from " + encrypted + " to " + original);
	return original;
	*/
    }

}
