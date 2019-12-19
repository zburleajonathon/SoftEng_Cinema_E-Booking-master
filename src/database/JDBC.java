
package termproj;

//STEP 1. Import required packages 
import java.security.SecureRandom; 
import java.util.*;
import java.lang.*;
import java.sql.*;
public class JDBC {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/termprojdb";
    
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
	public static String resetPassword(String email)
	{
		//returns "" (empty string) if email does not exist
		//returns new password if email does exist 
		//as 10 digit long casted to a string
		Connection conn = null;
		Statement stmt = null;
		String password = "";
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
			String sql = "SELECT email FROM User WHERE email = '" + email + "'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("THIS IS EMAIL GIVEN TO JDBC: " + email + "IN resetPassword()");
			
			if(rs.next()) 
			{//email exists
					System.out.println("WENT INTO IF(RS.NEXT()) IN RESETPASSWORD()");
					long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
					password = Long.toString(number); 
					sql = "SELECT adminEmail FROM Administrator WHERE adminEmail = '" + email + "'";
					rs = stmt.executeQuery(sql);
					if(rs.next()) 
					{//email exists and is an Administrator
					    sql = "UPDATE Administrator SET adminPassword = '" + Utilities.ept(password) 
						+ "' where adminEmail = '" + email + "'";
						int x = stmt.executeUpdate(sql);
					}//end of Administrator	 			
					
					else
					{//else the email exists is a Customer
						System.out.println("INSIDE CUSTOMER BLOCK IN JDBC.JAVA RESETPASSWORD()");
						sql = "UPDATE Customer SET password = '" + Utilities.ept(password) 
						+ "' where customerEmail = '" + email + "'";
						int y = stmt.executeUpdate(sql);
					}	
			}
			else
			{//email does not exist
				System.out.println("ERROR: EMAIL DOES NOT EXIST (CHECK IN resetPassword() in JDBC.java");
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
		System.out.println("Password is: " + password);
		System.out.println("Goodbye!");
    	return password;	
	}

    public static String forgotPassword(String email)
	{
		//returns emtpy string "" if email does not exist
		//returns non-emtpy string, which is password, if email does exist
		Connection conn = null;
		Statement stmt = null;
		String password = "";
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
			String sql = "SELECT email FROM User WHERE email = '" + email + "'";
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()) 
			{//email exists
					System.out.println("WENT INTO IF(RS.NEXT()) IN FORGOTPASSWORD()");
					//int id;
					sql = "SELECT adminEmail, adminPassword FROM Administrator WHERE adminEmail = '" + email + "'";
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) 
					{//email exists and is an Administrator
						System.out.println("INSIDE ADMIN BLOCK IN FORGOTPASSWORD()");
						while(rs.next())
						{
							System.out.println("WENT INTO ADMIN WHILE LOOP FORGOTPASSWORD");
							//Retrieve by column name
							//id = rs.getInt("userID");
							password = rs.getString("adminPassword");
						}		
					}//end of Administrator	 			
					
					else
					{//else the email exists is a Customer
						System.out.println("INSIDE CUSTOMER BLOCK IN JDBC.JAVA FORGOTPASSWORD()");
						sql = "SELECT password, phoneNumber FROM Customer WHERE customerEmail = '" + email + "'";
						rs = stmt.executeQuery(sql);
						
						while(rs.next())
						{
							System.out.println("INSIDE CUSTOMER WHILE LOOP in FORGOTPASSWORD()");
							//Retrieve by column name
							//id = rs.getInt("userID");
							password = rs.getString("password");
						}		
					}	
			}
			else
			{//email does not exist
				System.out.println("ERROR: EMAIL DOES NOT EXIST");
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
		System.out.println("Goodbye!");
		return Utilities.uept(password);	
	}
	
    public static int login(String email, String password)
    {
	//returns 0 if adminEmail exists and password is correct
	//returns 1 if customerEmail exists and password is correct
	//returns 2 if adminEmail exists and password is incorrect
	//returns 3 if customerEmail exists and password is incorrect
	//returns 4 if email does not exist 
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
		String sql = "SELECT email FROM User WHERE email = '" + email + "'";
		ResultSet rs = stmt.executeQuery(sql);

		if(rs.next()) 
		    {//email exists
			System.out.println("WENT INTO IF(RS.NEXT()) IN LOGIN");
			int id;
			String passw = "";
			sql = "SELECT adminEmail, adminPassword FROM Administrator WHERE adminEmail = '" + email + "'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) 
			    {//email exists and is an Administrator
				System.out.println("INSIDE ADMIN BLOCK IN LOGIN");
				System.out.println("CHECKING PASSWORD IN login() IN JDBC.java");
				//Retrieve by column name
				//id = rs.getInt("userID");
				passw = rs.getString("adminPassword");
				if(passw.equals(Utilities.ept(password)))
				    {//correct Admin password
					System.out.println("CORRECT ADMIN PASSWORD");
					returnValue = 0;
				    }
				else
				    {//incorrect ADMIN password
					System.out.println("INCORRECT ADMIN PASSWORD");
					returnValue = 2;
				    }	
			    }//end of Administrator	 			
			
			else
			    {//else the email exists is a Customer
				System.out.println("INSIDE CUSTOMER BLOCK IN JDBC.JAVA");
				sql = "SELECT password, phoneNumber FROM Customer WHERE customerEmail = '" + email + "'";
				rs = stmt.executeQuery(sql);
				
				while(rs.next())
				    {
					System.out.println("INSIDE CUSTOMER WHILE LOOP");
					//Retrieve by column name
					//id = rs.getInt("userID");
					passw = rs.getString("password");
					System.out.println("passw: " + passw);
					if(passw.equals(Utilities.ept(password)))
					    {//correct Customer password
						System.out.println("CORRECT CUSTOMER PASSWORD");
						returnValue = 1;
					    }
					else
					    {//incorrect Customer password
						System.out.println("INCORRECT CUSTOMER PASSWORD");
						returnValue = 3;
					    }	
				    }		
			    }	
		    }
		else
		    {//email does not exist
			System.out.println("ERROR: EMAIL DOES NOT EXIST");
			returnValue = 4;
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
	System.out.println("returnValue: " + returnValue);	
	System.out.println("Goodbye!");
    	return returnValue;	
    }

    public static int register(Customer newUser, Address newAddr, PaymentInfo payInfo) 
    {
	//returns 10 digit random confirmation pin if email address does not exist
	//returns 1 if email (and therefore user) already exists
	System.out.println("WENT INSIDE REGISTER() IN JDBC.java");
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
		String sql = "SELECT email FROM User WHERE email = '" 
		    + newUser.getEmail() + "'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) 
		    {//email exists
			System.out.println("ERROR: EMAIL ALREADY EXISTS IN register() in JDBC.java");
			returnValue = 1;
		    }
		else
		    {//email does not exist...proceed
			System.out.println("EMAIL DOESN'T EXIST SO CONTINUE IN REGISTER() IN JDBC.java");
			//Creating User first
			sql = "INSERT INTO User (email) values ('" 
			    + newUser.getEmail() + "')";//possible error: might need to add ; 
			int x = stmt.executeUpdate(sql);
			//Now creating Customer 
			//String phoneNumber = "1";//Integer.toString(newUser.getPhoneNumber());
			sql = "INSERT INTO Customer set password = '" 
			    + Utilities.ept(newUser.getPassword()) + "', userID = (select userID from User "
			    + "where email = '" + newUser.getEmail() + "'), customerEmail = '"
			    + newUser.getEmail() + "', firstName = '" + newUser.getFirstName() 
			    + "', lastName = '" + newUser.getLastName() + "', phoneNumber = '" 
			    + newUser.getPhoneNumber() + "', status = 'Inactive', age = 'Adult', subToPromo = " + newUser.getSubToPromo();
			x = stmt.executeUpdate(sql);
			//Now creating Address
			
			System.out.println("THIS IS ZIP: " + newAddr.getZip() + " IN REGISTER() IN JDBC.java");
			sql = "INSERT INTO Address (street, city, state, zip, userID) values "
			    + "('" + newAddr.getStreet() + "', '" + newAddr.getCity() + "', '" 
			    + newAddr.getState() + "', " + Integer.parseInt(newAddr.getZip()) + ", (select userID " 
			    + "from User where email = '" + newUser.getEmail() + "'))";
			x = stmt.executeUpdate(sql);
			//Now creating PaymentInfo
			//sql = "INSERT INTO PaymentInfo (cardNumber, name, Expiration, cardType, zip, userID) values "
			//+ "('" + payInfo.getCardNumber() + "', '" + payInfo.getName() + "', '" 
			//    + payInfo.getExpiration() + "', '" + "Visa"/*payInfo.getCardType()*/ + "', " + "30605"/*payInfo.getZip()*/ 
			//+ ", (select userID " + "from User where email = '" + newUser.getEmail() + "'))";
			//x = stmt.executeUpdate(sql);
			SecureRandom random = new SecureRandom();
			returnValue = random.nextInt(600) + 10000;

			System.out.println("AFTER STMT.EXECUTEQUERY(SQL) IN ELSE IN REGISTER() IN JDBC.java");
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
	System.out.println("CONFIRMATION PIN IS: " + returnValue);
	return returnValue;	
    }
    
    public static int editProfile(Customer customer, String potentialEmail) 
    {
	//returns 0 if successful edit profile
	//returns 1 if email (and therefore user) already exists as another user
	System.out.println("WENT INSIDE editProfile() IN JDBC.java");
	Connection conn = null;
	Statement stmt = null;
	String email = customer.getEmail();
	int returnValue = 0;
	int x = 0;
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
		String sql = "SELECT email FROM User WHERE email = '" 
		    + potentialEmail + "'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) 
		    {//email exists
			if(email.equals(potentialEmail))//customer did not change their email
			    {
				System.out.println("CUSTOMER DID NOT CHANGE EMAIL, UPDATING OTHER INFO");
				System.out.println("potentialEmail is: " + potentialEmail);
				Address customerAddr = customer.getAddress(); 
				if(customerAddr.getStreet() != null && customerAddr.getStreet() != "" && customerAddr.getZip() != null && customerAddr.getZip().length() > 0)
				    {
					System.out.println("ZIP IS " + customerAddr.getZip() + "IN editProfile");
					int zip = Integer.parseInt(customerAddr.getZip());
					sql = "UPDATE Address SET street = '" + customerAddr.getStreet() + "', city = '" 
					    + customerAddr.getCity() + "', state = '" + customerAddr.getState() + "', zip = "
					    + zip  + " WHERE userID = (select userID from User WHERE email = '" 
					    + potentialEmail + "')";
					x = stmt.executeUpdate(sql);
					System.out.println("editProfile(): AFTER CREATING ADDRESS");
				    }
				//Now creating PaymentInfo
				////////////////////////////////////////////////////////////////////NEED TO ADD CODE TO CHECK IF PAYMENT INFO ALREADY EXISTS
				PaymentInfo payInfo = customer.getPaymentInfo();
				if(payInfo.getCardNumber() != null && payInfo.getCardNumber() != ""){
				    int zip = 30605;  // default just in case
				    if(payInfo.getZip() != null) {
					zip = Integer.parseInt(payInfo.getZip());
				    }
				    sql = "UPDATE PaymentInfo SET cardNumber = '" + payInfo.getCardNumber() + "', name = '" 
					+ payInfo.getName() + "', Expiration = '" + payInfo.getExpiration() 
					+ "', zip = " + zip + " WHERE userID = (SELECT userID FROM User WHERE email = '" 
					+ email + "')";
				    x = stmt.executeUpdate(sql);
				}
				//NOW UPDATING Customer 
				sql = "UPDATE Customer set password = '" 
				    + Utilities.ept(customer.getPassword()) + "', userID = (select userID from User "
				    + "where email = '" + potentialEmail + "'), customerEmail = '"
					+ potentialEmail + "', firstName = '" + customer.getFirstName() 
					+ "', lastName = '" + customer.getLastName() + "', phoneNumber = '" 
					+ customer.getPhoneNumber() + "', status = 'Active', age = 'Adult', subToPromo = " + customer.getSubToPromo();
					x = stmt.executeUpdate(sql);
					System.out.println("editProfile(): AFTER UPDATING CUSTOMER");
					
					//Now creating Address 
				}
				else
				{//error: email exists as another user	
					System.out.println("ERROR: EMAIL EXISTS AS ANOTHER USER");
					returnValue = 1;
				}
			}
			else
			{//email does not exist in database...proceed
				System.out.println("CHANGING CUSTOMER'S EMAIL IN editProfile() IN JDBC.java");
				//CHANGING EMAIL IN CUSTOMER
				sql = "UPDATE Customer set customerEmail = '" + potentialEmail 
				+ "' where customerEmail = '" + email + "'";
				x = stmt.executeUpdate(sql);
				//CHANGING EMAIL IN USER
				sql = "UPDATE User set email = '" + potentialEmail 
				+ "' where email = '" + email + "'";
				x = stmt.executeUpdate(sql);
				//NOW UPDATING Customer 
				sql = "UPDATE Customer set password = '" 
				    + Utilities.ept(customer.getPassword()) + "', userID = (select userID from User "
				+ "where email = '" + potentialEmail + "'), customerEmail = '"
				+ potentialEmail + "', firstName = '" + customer.getFirstName() 
				+ "', lastName = '" + customer.getLastName() + "', phoneNumber = '" 
				+ customer.getPhoneNumber() + "', status = 'Active', age = 'Adult', subToPromo = " +  customer.getSubToPromo();
				x = stmt.executeUpdate(sql);
				//Now creating Address 
				Address customerAddr = customer.getAddress(); 
				sql = "UPDATE Address set street = '" + customerAddr.getStreet() + "', city = '" 
				+ customerAddr.getCity() + "', state = '" + customerAddr.getState() + "', zip = "
				+ customerAddr.getZip()  + " where userID = (select userID from User where where email = '" 
				+ potentialEmail + "')";
				x = stmt.executeUpdate(sql);
				//Now creating PaymentInfo
				//////////////////////////////////////////////////////NEED TO ADD CODE TO CHECK IF PAYMENT INFO ALREADY EXISTS
				PaymentInfo payInfo = customer.getPaymentInfo();
				sql = "UPDATE PaymentINfo set cardNumber = '" + payInfo.getCardNumber() + "', name = '" 
				+ payInfo.getName() + "', Expiration = '" + payInfo.getExpiration()  
				+ "', zip = " + payInfo.getZip() + " where userID = (select userID from User where where email = '" 
				+ potentialEmail + "')";
				x = stmt.executeUpdate(sql);

				System.out.println("FINISHED CHANGING EMAIL AND UPDATING INFO IN editProfile() IN JDBC.java");
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
		System.out.println("RETURNVALUE IS: " + returnValue);
		return returnValue;	
	}
	
	public static void changeCustomerStatus(String email) 
	{
		System.out.println("WENT INSIDE changeCustomerStatus() IN JDBC.java");
		Connection conn = null;
		Statement stmt = null;
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
			String sql = "SELECT email FROM User WHERE email = '" 
			+ email + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) 
			{//email exists
				System.out.println("EMAIL EXISTS INSIDE changeCustomerStatus() in JDBC.java");
				sql = "UPDATE Customer SET status = 'Active' where customerEmail = "
				+ "'" + email + "'";
				int x = stmt.executeUpdate(sql);
			}
			else
			{//email does not exist...proceed
				System.out.println("ERROR: EMAIL DOESN'T EXIST IN changeCustomerStatus() IN JDBC.java");
				//Creating User first
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
		System.out.println("EXITING changeCustomerStatus() in JDBC.java");
	}
    
	public static Customer getCustomer(String email)
	{
		//returns Customer object (with PaymentInfo and Address as its attributes) 
		Connection conn = null;
		Statement stmt = null;
		System.out.println("CUSTOMER EMAIL GIVEN TO getCustomer(): " + email);
		Customer customer = new Customer(null, null, null, null, null, null, null, false);
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
			String sql = "SELECT * FROM Customer WHERE customerEmail = '" + email + "'";
			ResultSet rs = stmt.executeQuery(sql);
			boolean blahh = rs.next();
			//GETTING CUSTOMER INFO
			System.out.println("GETTING CUSTOMER INFO IN getCustomer() in JDBC.java");
			int userID = rs.getInt("userID");
			System.out.println("AFTER userID");
			String cusEmail = rs.getString("customerEmail");
			String password = Utilities.uept(rs.getString("password"));				
			System.out.println("AFTER password");
			String firstName = rs.getString("firstName");
			System.out.println("AFTER firstName");
			String lastName = rs.getString("lastName");
			System.out.println("AFTER lastName");
			String phoneNumber = rs.getString("phoneNumber");
			System.out.println("AFTER phoneNumber");
			boolean subToPromo = rs.getBoolean("subToPromo");
			System.out.println("AFTER subToPromo");
			//BUILDING QUERY FOR ADDRESS
			sql = "SELECT * FROM Address WHERE userID = (select userID from Customer where customerEmail = '" + email + "')";
			rs = stmt.executeQuery(sql);
			//GETTING ADDRESS INFO		
			System.out.println("GETTING ADDRESS INFO IN getCustomer() in JDBC.java");		
			String street = "";
			int zip = 0;
			String state = "";
			String city = "";
			if(rs.next()) 
			{//
				street = rs.getString("street");
				zip = rs.getInt("zip");
				state = rs.getString("state");
				city = rs.getString("city");
			}//	 			
			else
			{//NO ADDRESS EXISTS FOR CUSTOMER; SENDING null FOR STREET, ZIP, STATE, CITY
				System.out.println("NO ADDRESS EXISTS FOR CUSTOMER; IN getCustomer() IN JDBC.java");
			}	
			Address address = new Address(street, Integer.toString(zip), state, city);
			//BUILDING QUERY FOR PaymentInfo
			sql = "SELECT * FROM PaymentInfo WHERE userID = (select userID from Customer where customerEmail = '" + email + "') order by paymentID desc limit 0, 1";
			rs = stmt.executeQuery(sql);
			//GETTING PAYMENT INFO
			System.out.println("GETTING PAYMENT INFO IN getCustomer() in JDBC.java");		
			String cardNumber  = "";
			String name  = "";
			String Expiration  = "";
			String ccv = ""; //this is number on back of credit card
			String cardType  = "";
			int zip2 = 0;
			if(rs.next()) 
			{//
				cardNumber = rs.getString("cardNumber");
				name = rs.getString("name");
				Expiration = rs.getString("Expiration");
				cardType = rs.getString("cardType");
				zip2 = rs.getInt("zip");
				ccv = rs.getString("ccv");
			}//	 			
			else
			{//NO PaymentInfo EXISTS FOR CUSTOMER; SENDING null FOR STREET, ZIP, STATE, CITY
				System.out.println("NO PaymentInfo EXISTS FOR CUSTOMER; IN getCustomer() IN JDBC.java");
			}	
			PaymentInfo payInfo = new PaymentInfo(cardNumber, name, Expiration, cardType, ccv, Integer.toString(zip2));
			customer = new Customer(firstName, lastName, email, password, address, payInfo, phoneNumber, subToPromo);
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
		System.out.println("EXITING getCustomer() with customer.getEmail() as " + customer.getEmail());
    	return customer;	
	}
	
	public static int deleteCustomer(String email)
	{
		//returns 0 if delete successful or 1 if customer doesn't exist
		Connection conn = null;
		Statement stmt = null;
		System.out.println("CUSTOMER EMAIL GIVEN TO deleteCustomer() in JDBC.java: " + email);
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
			String sql = "SELECT * FROM Customer WHERE customerEmail = '" + email + "'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) 
			{//customer exists, so delete
				//DELETING PaymentInfo ENTRY IF EXISTS
				sql = "SELECT * FROM PaymentInfo WHERE userID = (SELECT userID FROM User WHERE email = '" + email + "'";
				rs = stmt.executeQuery(sql);
				if(rs.next())
				{
					sql = "DELETE FROM PaymentInfo WHERE userID = (SELECT userID FROM User WHERE email = '" + email + "'"; 
					stmt.executeUpdate(sql);
				}
				//DELETING ADDRESS ENTRY IF EXISTS
				sql = "SELECT * FROM Address WHERE userID = (SELECT userID FROM User WHERE email = '" + email + "'";
				rs = stmt.executeQuery(sql);
				if(rs.next())
				{
					sql = "DELETE FROM Address WHERE userID = (SELECT userID FROM User WHERE email = '" + email + "'"; 
					stmt.executeUpdate(sql);
				}
				//DELETING FROM Customer TABLE
				sql = "DELETE FROM Customer WHERE customerEmail = '" + email + "'";
				stmt.executeUpdate(sql);
				//DELTEING FROM User TABLE
				sql = "DELETE FROM User WHERE email = '" + email + "'";
				stmt.executeUpdate(sql);
			}//	 			
			else
			{//error: customer doesn't not exist
				System.out.println("CUSTOMER DOESN'T EXIST IN deleteCustomer() IN JDBC.java");
				returnValue = 1;
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
		System.out.println("EXITING deleteCustomer() with returnValue " + returnValue);
    	return returnValue;	
	}
    
}//end JDBC
