package termproj;

import java.util.*;
import java.lang.*;
import java.sql.*;

public class MovieJDBC {
	//methods in this class are getMovie(), getAllMovies(), getShowtime()   

	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/termprojdb";
    
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    public static Movie getMovie(String name)
	{
		Connection conn = null;
		Statement stmt = null;
		Movie movie = new Movie();
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
			String sql = "SELECT * FROM Movie WHERE name = '" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) 
			{//Movie exists
					int runtime = rs.getInt("runtimeMins");
					String trailer = rs.getString("trailer");
					String cast  = rs.getString("cast");
					String rating = rs.getString("rating");
					String genre = rs.getString("genre");
					String review = rs.getString("review");
					movie = new Movie(name, runtime, trailer, cast, rating, genre, review);
			}
			else
			{// 
				System.out.println("ERROR: MOVIE DOESN'T EXIST");
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
		System.out.println("EXITING getMovie() in MovieJDBC.java");
    	return movie;	
	}
    
	public static ArrayList<Movie> getAllMovies()
	{
		Connection conn = null;
		Statement stmt = null;
		Movie movie = new Movie();
		ArrayList<Movie> movieList = new ArrayList<Movie>();
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
			String sql = "SELECT * FROM Movie";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) 
			{//each row in Movie table
					String name = rs.getString("name");
					int runtime = rs.getInt("runtimeMins");
					String trailer = rs.getString("trailer");
					String cast  = rs.getString("cast");
					String rating = rs.getString("rating");
					String genre = rs.getString("genre");
					String review = rs.getString("review");
					movie = new Movie(name, runtime, trailer, cast, rating, genre, review);
					movieList.add(movie);
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
		System.out.println("EXITING getMovie() in MovieJDBC.java");
    	return movieList;	
	}
	
	public static ArrayList<Showtime> getAllShowtimes(String movieName)
	{
		Connection conn = null;
		Statement stmt = null;
		Showtime showtime = new Showtime();
		ArrayList<Showtime> showtimeList = new ArrayList<Showtime>();
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
			String sql = "SELECT * FROM Showtime WHERE movieID = (SELECT movieID FROM Movie WHERE name = '" + movieName + "')";
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) 
			{//each row in Showtime table
					String date = rs.getString("date");
					String time = rs.getString("time");
					String status = rs.getString("showStatus");
					int movieID = rs.getInt("movieID");
					int hallID = rs.getInt("hallID");
					int remainingSeats = rs.getInt("remainingSeats");
					showtime = new Showtime(date, time, status, movieID, hallID, remainingSeats);
					showtimeList.add(showtime);
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
		System.out.println("EXITING getAllShowtimes() in MovieJDBC.java");
    	return showtimeList;	
	}
    
	public static int addMovie(Movie movie)
	{
		//return 0 if movie added or 1 if movie already exists
		
		Connection conn = null;
		Statement stmt = null;
		int returnValue = 0;
		String name = movie.getName();
		String trailer = movie.getTrailer();
		String cast = movie.getCast();
		String rating = movie.getRating();
		String genre = movie.getGenre();
		String review = movie.getReview();
		int runtimeMins = movie.getRuntime();
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
			String sql = "SELECT * FROM Movie WHERE name = '" + name + "'";
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) 
			{
				System.out.println("ERROR: MOVIE ALREADY EXISTS");
				returnValue = 1;
			}
			else
			{
				System.out.println("MOVIE DOESN'T EXIST, SO ADDING MOVIE");
				//ADDING MOVIE INTO MYSQL DATABASE
				sql = "INSERT INTO Movie (name, trailer, cast, rating, "
				+ "genre, review, runtimeMins) values ('" + name + "', '" 
				+ trailer + "', '" + cast + "', '" + rating + "', '" 
				+ genre + "', '" + review + "', " + runtimeMins + ")";
				int x = stmt.executeUpdate(sql);
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
		System.out.println("EXITING addMovie() in MovieJDBC.java with returnValue" 
		+ returnValue);
    	return returnValue;	
	}
    
}//end JDBC
