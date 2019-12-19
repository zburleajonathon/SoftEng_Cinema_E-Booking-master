
package termproj;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import freemarker.template.*;
import java.util.ArrayList;

public class BookMaster {

    static int checkout(Address address, PaymentInfo payment, HttpSession session) {
	int retVal = 0;
	// Get params from Session
	String movieName = session.getAttribute("movieName").toString();
	String showtimeStr = session.getAttribute("showtime").toString();
	int numSeats = Integer.parseInt(session.getAttribute("numSeats").toString());
	int childTickets = Integer.parseInt(session.getAttribute("childTickets").toString());
	int adultTickets = Integer.parseInt(session.getAttribute("adultTickets").toString());
	int seniorTickets = Integer.parseInt(session.getAttribute("seniorTickets").toString());
	String email = session.getAttribute("userEmail").toString();
	String seats[] = getSessionSeats(session, numSeats);
	// create a booking object
	Showtime showtime = makeShowtime(movieName, showtimeStr);
	Customer customer = JDBC.getCustomer(email);
	customer.setAddress(address);
	customer.setPaymentInfo(payment);
	Booking booking = new Booking(customer, payment, showtime);
	// create and add the tickets to booking
	int seatIndex = 0;
	for(int i = 0; i < childTickets; i++) {
	    TicketType t = TicketType.CHILD;
	    Ticket ticket = makeTicket(movieName, t, showtimeStr, seats[seatIndex]);
	    booking.addTicket(ticket);
	    seatIndex++;
	}
	for(int i = 0; i < adultTickets; i++) {
	    TicketType t = TicketType.ADULT;
	    Ticket ticket = makeTicket(movieName, t, showtimeStr, seats[seatIndex]);
	    booking.addTicket(ticket);
	    seatIndex++;
	}
	for(int i = 0; i < seniorTickets; i++) {
	    TicketType t = TicketType.SENIOR;
	    Ticket ticket = makeTicket(movieName, t, showtimeStr, seats[seatIndex]);
	    booking.addTicket(ticket);
	    seatIndex++;
	}
	// check for promos
	if(session.getAttribute("promo") != null) {
	    String promoStr = session.getAttribute("promo").toString();
	    //double promoRate = Utilities.checkForPromo(promoStr);
	    double promoRate = getPromoRate(promoStr);
	    Promo promo = new Promo(promoStr, promoRate);
	    booking.setPromo(promo);
	}
	
	bookingDebug(booking);
	
	//double totalPrice = BookingJDBC.bookTickets(booking);
	//bookTickets returns: arr[0] as totalPrice and arr[1] as bookingConfirmation
	double [] arr = BookingJDBC.bookTickets(booking);
	double totalPrice = arr[0];
	double bookingConf = arr[1];
	int bookingConfirmation = (int)bookingConf; 
	String priceStr = totalPrice + "";
	session.setAttribute("price", priceStr);
	session.setAttribute("bookingNum", bookingConfirmation);
	System.out.println("End of BookMaster.checkout(). Price = " + totalPrice);
	// confirmation stuff?
	return retVal;
    }

    static void bookingDebug(Booking booking) {
	System.out.println("This is the booking we are sending to JDBC:");
	System.out.println("\t Date: " + booking.getDate());
	System.out.println("\t Time: " + booking.getTime());
	System.out.println("\t Movie: " + booking.getMovieName());
	System.out.println("\t Seats selected: ");
	for(int i = 0; i < booking.getNumTickets(); i++) {
	    System.out.println("\t\t Seat for ticket "+i+": "+booking.getTicket(i).getSeatNum());
	}
    }

    static String[] getSessionSeats(HttpSession session, int numSeats) {
	String[] seats = new String[numSeats];
	int j = 0;
	for(int i = 1; i <= 120; i++) {
	    String seatStr = "seat" + i;
	    if(session.getAttribute(seatStr) != null) {
		String seatVal = session.getAttribute(seatStr).toString();
		if(! seatVal.equals("empty")) {
		    seats[j] = seatVal;
		    j++;
		}
		if(j == numSeats) {
		    break;
		}
	    }
	}
	return seats;
    }

    static boolean verifySeating(HttpSession session, HttpServletRequest request) {
	int numSeats = Integer.parseInt(request.getParameter("numSeats"));
	int childTickets = Integer.parseInt(request.getParameter("childs"));
	int adultTickets = Integer.parseInt(request.getParameter("adults"));
	int seniorTickets = Integer.parseInt(request.getParameter("seniors"));
	if(numSeats != (childTickets + adultTickets + seniorTickets)) {
	    return false;
	}
	if(numSeats <= 0) {
	    return false;
	}
	if(countSeatSelection(session, request) != numSeats) {
	    return false;
	}
	return true;
    }

    static int countSeatSelection(HttpSession session, HttpServletRequest request) {
	int numSelected = 0;
	for(int i = 1; i <= 120; i++) {
	    String seatStr = "seat" + i;
	    String seatVal = request.getParameter(seatStr);
	    if(seatVal != null) {
		numSelected += 1;
	    }
	}
	return numSelected;
    }
    
    static int saveSeatSelection(HttpSession session, HttpServletRequest request) {
	int numSelected = 0;
	System.out.println("Saving seats...");
	for(int i = 1; i <= 120; i++) {
	    String seatStr = "seat" + i;
	    String seatVal = request.getParameter(seatStr);
	    if(seatVal != null) {
		System.out.println("Saving seat with name: " + seatVal);
		session.setAttribute(seatStr, seatVal);
		numSelected += 1;
	    }
	    else {
		session.setAttribute(seatStr, "empty");
	    }
	}
	return numSelected;
    }

    static int getSeatNum(String seatStr) {
	String letter = seatStr.substring(0, 1);
	String numStr = seatStr.substring(1);
	int num = Integer.parseInt(numStr);
	switch(letter) {
	case "A": return num;
	case "B": return num + 12;
	case "C": return num + 24;
	case "D": return num + 36;
	case "E": return num + 48;
	case "F": return num + 60;
	case "G": return num + 72;
	case "H": return num + 84;
	case "I": return num + 96;
	case "J": return num + 108;
	}
	System.out.println("Error in BookMaster.getSeatNum(). Returning -1");
	return -1;
    }
    
    static boolean seatNumCheck(String totalSeats, String childs, String adults, String seniors) {
	int total = Integer.parseInt("totalSeats");
	int childSeats = Integer.parseInt("childs");
	int adultSeats = Integer.parseInt("adults");
	int seniorSeats = Integer.parseInt("seniors");
	return total == (childSeats + adultSeats + seniorSeats);
    }
    
    static Ticket makeTicket(String movieN, TicketType t, String showtimeStr, String seatNumStr) {
	Showtime showtime = makeShowtime(movieN, showtimeStr);
	Seat seat = makeSeat(seatNumStr);
	Hall hall = showtime.getHall();
	seat.setHallName(hall.getName());
	//TicketType ticketType = getTicketType(ageStr);
	Movie movie = MovieJDBC.getMovie(movieN);
	Ticket ticket = new Ticket(showtime, hall, t, seat, movie);
	return ticket;
    }
    
    static Showtime makeShowtime(String movieName, String showtimeStr) {
	ArrayList<Showtime> showtimeList = MovieJDBC.getAllShowtimes(movieName);
	String[] splitStr = showtimeStr.split("\\s+");
	if(splitStr.length != 3) {
	    System.out.println("Improper showtime input in bookMovie");
	    System.out.println("Exiting from BookMaster.makeShowtime()");
	}
	String date = splitStr[0];
	String time = splitStr[1];
	String hallName = splitStr[2];
	int convertedTime = Utilities.convertTime(time);
	String convertedTimeStr = String.valueOf(convertedTime);
	Showtime showtime = null;
	int numShowtimes = showtimeList.size();
	System.out.println("date is " + date + " and time is " + convertedTimeStr);
	for(int i = 0; i < numShowtimes; i++) {
	    Showtime s = showtimeList.get(i);
	    
	    if(date.equals(s.getDate()) && convertedTimeStr.equals(s.getTime())) {
		showtime = s;
		System.out.println("found the showtime");
		break;
	    }
	}
	Hall hall = new Hall(showtime.getHallID(), hallName);
	Movie movie = MovieJDBC.getMovie(movieName);
	showtime.setMovie(movie);
	showtime.setHall(hall);
	//Movie movie = new Movie(movieName);
	//Showtime showtime = new Showtime(hall, date, time, movie);
	return showtime;
    }
    
    static Movie makeMovie(String movieName) {
	return new Movie(movieName);  // temp, can add stuff
    }
    static Hall makeHall(String HallID) {
	//String IDstr = HallID.substring(1, HallID.length()-1);
	//int hallID = Integer.parseInt(IDstr);
	//Hall hall = new Hall(hallID, IDstr);
	return new Hall();
    }
    static Seat makeSeat(String seatNumStr) {
	int seatNum = getSeatNum(seatNumStr);
	Seat seat = new Seat(seatNum);
	return seat;
    }

    static double getConvFee(int numSeats) {
	return numSeats * 1.64;
    }
    static double getTax(double total, double promoRate) {
	total = total * promoRate;
	return total * 0.081;
    }
    static double getPromoRate(String promoName) {
	String rateStr = promoName.substring(promoName.length()-2);
	double rate = Double.parseDouble(rateStr);
	rate = 100 - rate;
	return rate/100;
    }
    static double computeCost(int childs, int adults, int seniors, double promoRate, int time) {
	double convenienceFee = 1.64;
	double taxRate = 0.081;
	double total = childCost(childs) + adultCost(adults, time) + seniorCost(seniors);
	if(promoRate > 0.001) {
	    total = total * promoRate;
	}
	total += (total * taxRate) + (childs + adults + seniors) * convenienceFee;
	return total;
    }
    static double computeCost(int childs, int adults, int seniors, int time) {
	return computeCost(childs, adults, seniors, 0);
    }
    /*
    static double computeCost(int childs, int adults, int seniors, String promoName, int time) {
	
    }
    static double computeCost(int childs, int adults, int seniors, Promo promo, int time) {
	
    }
    */
    /*
    static double computeCost(double chCost, double adCost, double srCost, double promoRate) {
	double convenienceFee = 1.64;
	double taxRate = 0.081;
    }
    */
    static double childCost(int childTickets) {
	return childTickets * 7.79;
    }
    static double childCost(String childTickets) {
	return childCost(Integer.parseInt(childTickets));
    }
    static double adultCost(int adultTickets, int time) {
	double total = 0.0;
	if(time < 1600) {
	    total = 8.49 * adultTickets;
	}
	else {
	    total = 10.79 * adultTickets;
	}
	return total;
    }
    static double seniorCost(int seniorTickets) {
	return seniorTickets * 8.29;
    }
    

}
