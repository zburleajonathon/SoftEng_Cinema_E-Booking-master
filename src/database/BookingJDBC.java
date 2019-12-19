package termproj;

import java.security.SecureRandom; 
import java.util.*;
import java.lang.*;
import java.sql.*;

public class BookingJDBC {
	//methods in this class are checkSeatStatus(), setSeatStatus()    

	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/termprojdb";
    
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    public static int checkSeatStatus(Seat seat, Showtime showtime)
	{
		//returns 0 if seat is available
		//returns 1 if seat is unavailable 
		Connection conn = null;
		Statement stmt = null;
		int returnValue = 0;
		try 
		{
	        //STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql = "SELECT status FROM SeatStatus WHERE seatNum = " + seat.getSeatNum() 
			+ " and showtimeID = " + showtime.getShowtimeID();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) 
			{//SeatStatus exists
					System.out.println("WENT INTO IF(RS.NEXT()) IN checkSeatStatus()");
					String status = rs.getString("status");
					String valid = "Valid";
					System.out.println("status from database: " + status);
					if(status.equals(valid))
					{
						System.out.println("SeatStatus EXISTS AND SEAT IS AVAILABLE");
					}
					else
					{
						System.out.println("SeatStatus EXISTS AND SEAT IS ALREADY BOOKED");
						returnValue = 1;
					}	
			}
			else
			{//seat is probably not booked yet since no entry in SeatStatus 
				System.out.println("SeatStatus DOESN'T EXIST SO SEAT IS AVAILABLE");
			}
	 			
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}//end of try
		catch(SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
			try
			{
				if(stmt!=null)
					stmt.close();
			}
			catch(SQLException se2)
			{
			}// nothing we can do
			try
			{
				if(conn!=null)
					conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("EXITING checkSeatStaus() with returnValue: " + returnValue + " in BookingJDBC.java");
    	return returnValue;	
	}
    
	public static void setSeatStatus(Seat seat, Showtime showtime, String status)
	{//the parameter String status is included in case an existing 
	 //SeatStatus is being changed.  status will either be 'Valid' or 'Invalid'

		Connection conn = null;
		Statement stmt = null;
		int x;//just a return value for executeUpdate()
		try 
		{
	        //STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			//STEP 4: Execute a query
			System.out.println("Creating statement in setSeatStatus()");
			stmt = conn.createStatement();
			String sql = "SELECT status FROM SeatStatus WHERE seatNum = " + seat.getSeatNum() 
			+ " and showtimeID = " + showtime.getShowtimeID();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) 
			{//SeatStatus for seat exists
					System.out.println("SeatStatus DOES EXIST SO CHANGING status IN DATABASE");
					sql = "UPDATE SeatStatus SET status = '" + status + "' where "
					+ "seatNum = " + seat.getSeatNum() + " and showtimeID = " 
					+ showtime.getShowtimeID();		
					x = stmt.executeUpdate(sql);
			}
			else
			{//seat is probably not booked yet since no entry in SeatStatus 
				System.out.println("SeatStatus DOESN'T EXIST SO SeatStatus WILL BE CREATED AND BOOKED");
				sql = "INSERT INTO SeatStatus SET showtimeID = " + showtime.getShowtimeID() 
				+ ", seatNum = " + seat.getSeatNum() + ", status = '" + status + "'";
				x = stmt.executeUpdate(sql);
			}
	 			
			//STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		}//end of try
		catch(SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
			try
			{
				if(stmt!=null)
					stmt.close();
			}
			catch(SQLException se2)
			{
			}// nothing we can do
			try
			{
				if(conn!=null)
					conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("EXITING setSeatStaus() in BookingJDBC.java");
	}
    
    public static double [] bookTickets(Booking booking)
	{
		Connection conn = null;
		Statement stmt = null;
		Customer customer = booking.getCustomer();
		SecureRandom random = new SecureRandom();
        int bookingConfirmation = random.nextInt(600) + 10000;
		// check if promo exists
		boolean usedPromo = booking.hasPromo();
		Promo promo = null;
		String promoName = "";
		double promoRate = -1;
		if(usedPromo) {
		    promo = booking.getPromo();
		    promoName = promo.getPromoName();///////////////////promoID////////////////
		    System.out.println("USED PROMO...IN bookTicket()");
		    promoRate = promo.getPromoRate();
		}
	  	String email = customer.getEmail();///////////////////userID//////////////////
		ArrayList<Ticket> tickets = booking.getTickets();
		int numSeats = tickets.size();
		System.out.println("ArrayList TICKETS SIZE: " + numSeats);
		
		Showtime showtime = tickets.get(0).getShowtime();
		Hall hall = showtime.getHall();
		int hallID = hall.getHallID(); //////////////////////hallID
		//int showtimeID = showtime.getShowtimeID();////////////////////showtimeID
		//ResultSet rs2 = 
	
		//int bookingConfirmation = booking.getConfirmID(); //////////////bookingConfirmation
		int time = Integer.parseInt(showtime.getTime());
		double convenienceFee = 1.64;
		double taxRate = 0.081;
		double total = 0;	
		PaymentInfo payInfo = customer.getPaymentInfo();///////////paymentID////////////////
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			System.out.println("Showtime date : " + showtime.getDate() + ", time: " + showtime.getTime() + ", movieID: " + showtime.getMovieID() + ", hallID: " + hallID);
			String sql = "SELECT showtimeID FROM Showtime WHERE date = '" + showtime.getDate() + "' AND time = '" + showtime.getTime() + "' AND movieID = " + showtime.getMovieID() + " AND hallID = " + hallID;
			ResultSet rs = stmt.executeQuery(sql);
		
			boolean sdfk = rs.next();
			String showtimeID = rs.getString("showtimeID");
			//check if payment info exists; if not, create
			int y = JDBC.editProfile(customer, email);
			
			//calculate total from all ticket prices
			for(int x = 0; x < tickets.size(); x++)
			{
				Ticket ticket = tickets.get(x);
				TicketType type = ticket.getType();
				if(type == TicketType.ADULT)
				{
					if(time < 1600)	
					{
						System.out.println("TICKET IS MATADULT IN bookTicket()");
						total = total + 8.49; //matinee
					}
					else
					{
						System.out.println("TICKET IS EVEADULT IN bookTicket()");
						total = total + 10.79; //evening
					}
				}	
				else if(type == TicketType.CHILD)
				{	
					System.out.println("TICKET IS CHILD IN bookTicket()");
					total = total + 7.79;
				}
				else
				{//senior price
					System.out.println("TICKET IS SENIOR IN bookTicket()");
					total = total + 8.29;
				}
			}
			if(promoRate > 0.000001)//SET TO 0 IN SERVLET IF NO PROMO
			{
				System.out.println("THIS IS PROMORATE USED IN bookTicket(): " + promoRate);
				total = total * promoRate; 
				usedPromo = true;
			}
			total += (total * taxRate) + numSeats * convenienceFee;

			sql = "SELECT paymentID FROM PaymentInfo where cardNumber = '" + payInfo.getCardNumber()
			+ "'";
			rs = stmt.executeQuery(sql);
			int paymentID = 0;
			if(rs.next())
			{//PaymentInfo exists, so set paymentID
				paymentID = rs.getInt("paymentID");
			}
			else
			{//PaymentInfo doesn't exist, so create it in PaymentInfo table
				sql = "INSERT INTO PaymentInfo (cardNumber, name, Expiration, zip, userID, ccv) " 
				+ "values ('" + payInfo.getCardNumber() + "', '" + payInfo.getName() + "', '" + payInfo.getExpiration() 
				+ "', " + Integer.parseInt(payInfo.getZip()) + ", " 
				+ "(select userID from Customer where customerEmail = '" + email + "'), '"
				+ payInfo.getCcv() + "')";  
				int blah = stmt.executeUpdate(sql);
				//NOW GET PAYMENTID
				sql = "SELECT paymentID from PaymentInfo where cardNumber = '" + payInfo.getCardNumber() + "'";
				rs = stmt.executeQuery(sql);
				boolean jkljl = rs.next();
				paymentID = rs.getInt("paymentID");
			}
			//all Booking column values are int except total, which is DECIMAL
			//need userID, paymentID, bookingConfirmation, showtimeID, hallID, promoID, total 
			if(usedPromo)
			{
				sql = "INSERT INTO Booking (userID, paymentID, bookingConfirmation, showtimeID, hallID, promoID, total) values " 
				+ "((select userID from Customer where customerEmail = '" + email + "'), " + paymentID + ", " + bookingConfirmation
				+ ", (SELECT showtimeID FROM Showtime WHERE showtimeID = " + showtimeID + ", " + hallID + ", (select promoID from Promos where promoName = '" + promoName //might need to modify
				+ "'), " + total + ")";  
				int blah2 = stmt.executeUpdate(sql);	
			}
			else
			{
				System.out.println("SHOWTIMEID: " + showtimeID);
				sql = "INSERT INTO Booking (userID, paymentID, bookingConfirmation, showtimeID, hallID, total) values " 
				+ "((select userID from Customer where customerEmail = '" + email + "'), " + paymentID + ", " + bookingConfirmation
				+ ", (SELECT showtimeID FROM Showtime WHERE showtimeID = " + showtimeID + "), " + hallID + ", " + total + ")";  
				int blah3 = stmt.executeUpdate(sql);	
			}
			for(int x = 0; x < tickets.size(); x++)
			{
				//CREATING SeatStatus FOR SEAT
				Ticket ticket2 = tickets.get(x);
				Seat seat = ticket2.getSeat();
				TicketType type2 = ticket2.getType();
				String sqlType = "";
				//sql = "SELECT status FROM SeatStatus WHERE seatNum = " + seat.getSeatNum() 
				//+ " and showtimeID = " + showtime.getShowtimeID();
				sql = "INSERT INTO SeatStatus (showtimeID, seatID, status) values (" + showtimeID 
				+ ", (select seatID from Seat where hallID = " + hallID + " and seatNum = " + seat.getSeatNum() 
				+ "), status = 'Valid')";
				int blah4 = stmt.executeUpdate(sql);
				//GET BOOKINGID
				sql = "SELECT bookingID from Booking where bookingConfirmation = " + bookingConfirmation;
				rs = stmt.executeQuery(sql);
				boolean kjsdfl = rs.next();
				int bookingID = rs.getInt("bookingID");
				//CREATING Ticket FOR SEAT
				if(type2 == TicketType.ADULT)
				{
					if(time < 1600)
					{
						sqlType = "MATADULT";
					}
					else
					{
						sqlType = "EVEADULT";
					} 
				}
				else if(type2 == TicketType.CHILD)
				{
					sqlType = "CHILD";
				}
				else
				{//SENIOR
					sqlType = "SENIOR";
				}
				sql = "INSERT INTO Ticket (bookingID, seatID, typeID) VALUES ("
				+ bookingID + ", (SELECT seatID FROM Seat WHERE hallID = " + hallID + " AND seatNum = " + seat.getSeatNum() 
				+ "), (select typeID FROM TicketType WHERE type = '" + sqlType + "'))";
				int blah5 = stmt.executeUpdate(sql);
	 		}
			sql = "SELECT remainingSeats FROM Showtime WHERE showtimeID = " + showtimeID;	
			rs = stmt.executeQuery(sql);
			boolean kjsfsf = rs.next();
			int rem = rs.getInt("remainingSeats");
			rem = rem - numSeats;
			sql = "UPDATE Showtime set remainingSeats = " + rem + " WHERE showtimeID = " + showtimeID;			
			int blah6 = stmt.executeUpdate(sql);
	
			rs.close();
			stmt.close();
			conn.close();
		}//end of try
		catch(SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
			try
			{
				if(stmt!=null)
					stmt.close();
			}
			catch(SQLException se2)
			{
			}// nothing we can do
			try
			{
				if(conn!=null)
					conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("EXITING bookTickets() in BookingJDBC.java");
		total = Math.round(total*100.0)/100.0;
		double bookingConf = (double)bookingConfirmation;
		double [] returnArray = new double[2];
		returnArray[0] = total; 
		returnArray[1] =  bookingConf;
		return returnArray;
	}
}//end JDBC
