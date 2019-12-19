
package termproj;
//import javax.mail.jar;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validate {

    static boolean oneNotNull(String ... s){
	for(String str : s){
	    if(str != null && !str.isEmpty()){
		System.out.println("oneNotNull() worked");
		return true;
	    }
	}
	return false;	
    }
    
    static boolean noNulls(String ... s) {
	for(String str : s) {
	    if(str == null || str.isEmpty()) {
		return false;
	    }
	}
	return true;
    }
	
    static int registerCheck(Customer newUser, String password2) {
	//Returns 5 digit confirmation pin if everything is gucci
	//Returns 1 if User already exists
	//Returns 2 if Passwords do not match
	//Returns 3 if Address is not formatted properly
	//Returns 4 if Email is invalid
	int retVal = 0;
	System.out.println("validating registration");
	
	//Checks if confirmed password is the same as password
	String password = newUser.getPassword();
	if(!password.equals(password2)) {
	    return 2;
	}

	Address address = newUser.getAddress();
	PaymentInfo info = newUser.getPaymentInfo();
	
	//Checks if user already exits
	retVal = JDBC.register(newUser, address, info);
	if (retVal == 1){
	    return retVal;
	}
	/*
	//Check if Address is properly formated
	String validateZip = address.getZip();
	int length = validateZip.length();
	if (length != 5){
	    return 3;
	}
	    */
	/*
	String validateCity = address.getCity();
	if (!validateCity.equalsIgnoreCase("Atlanta") || !validateCity.equalsIgnoreCase("Athens")){
	    return 3;
	}
	*/

	//Checks if email has a valid format
	String validateEmail = newUser.getEmail();
	boolean valid = isValid(validateEmail);
	if (!valid){
	    return 4;
	}
	System.out.println("Returning " + retVal);
	return retVal;
    }


    /*
    static int bookingValidation(String movieN, String ageStr, String showtimeStr, String seatNumStr) {
   	int retVal = 0;
        // Ticket has Showtime, Hall, TicketType, and Seat objects
        // Ticket ticket = makeTicket(movieN, ageStr, showtimeStr, seatNumStr);
	// pass the ticket to database for possible processing, or maybe not until after checkout?
        return retVal;
    }
    */
    
    static int checkoutValidation(Address address, PaymentInfo payment) {
	//Returns 0 if everything is gucci
	//Returns 1 if not a valid street address
	//Returns 2 if zip code is not valid
	int retVal = 0;
	if (!validateStreetAddress(address.getStreet())){
	    retVal = 1;
	    System.out.println("Billing street incorrect format");
	}
	if (!validateZipCode(address.getZip())){
	    retVal = 2;
	    System.out.println("Billing zip code incorrect format");
	}

	return retVal;
    }

    public static boolean isValid(String email) { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    }

    public static boolean validateStreetAddress(String street){
	String streetRegex = "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)";
	
	Pattern pat = Pattern.compile(streetRegex);
	if (street == null)
	    return false;
        return pat.matcher(street).matches();
    }

    public static boolean validateZipCode(String zip){
	String zipRegex = "^[0-9]{5}(?:-[0-9]{4})?$";

	Pattern pat = Pattern.compile(zip);
	if (zip == null)
	    return false;
	return pat.matcher(zip).matches();
    }
}
