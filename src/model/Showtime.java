
package termproj;

public class Showtime {
    int showtimeID;
    Hall hall;
    int hallID;
    int movieID;
    int remainingSeats;
    String date;
    String status;
    String time;
    Movie movie;
    // ShowStatus status;

    // Constructors
    Showtime() {
	
    }
    Showtime(Hall hall, String date, String time, Movie movie) {
	setHall(hall);
	setDate(date);
	setTime(time);
	setMovie(movie);
    }
    //this constructor used in MovieJDBC.java
    Showtime(String date, String time, String status, int movieID, int hallID, int remainingSeats)
    {
	setDate(date);
	setTime(time);
	setStatus(status);
	setMovieID(movieID);
	setHallID(hallID);
	setRemainingSeats(remainingSeats);
    }
    
    // Getters
    Hall getHall() 
    {
	return hall;
    }
    String getDate() 
    {
	return date;
    }
    String getTime() 
    {
	return time;
    }
    Movie getMovie() 
    {
	return movie;
    }
    String getStatus()
    {
	return status;	
    }
    int getMovieID()
    {
	return movieID;
    }
    int getHallID()
    {
	return hallID;
    }
    int getRemainingSeats()
    {
	return remainingSeats;
    }
    int getShowtimeID()
    {
	return showtimeID;
    }
    
    // Setters
    void setShowtimeID(int showtimeID)
    {
	this.showtimeID = showtimeID;	
    }
    void setHall(Hall hall) {
	this.hall = hall;
    }
    void setDate(String date) {
	this.date = date;
    }
    void setTime(String time) {
	this.time = time;
    }
    void setMovie(Movie movie) {
	this.movie = movie;
    }
    void setStatus(String status)
    {
	this.status = status;
    }	
    void setMovieID(int movieID)
    {
	this.movieID = movieID;
    }
    void setHallID(int hallID)
    {
	this.hallID = hallID;
    }
    void setRemainingSeats(int remainingSeats)
    {
	this.remainingSeats = remainingSeats;
    }
    
}
