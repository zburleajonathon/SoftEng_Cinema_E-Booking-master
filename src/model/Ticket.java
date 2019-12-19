
package termproj;

public class Ticket {
    Showtime showtime;
    Hall hall;
    TicketType type;
    Seat seat;
    Movie movie;
    
    // Constructors
    Ticket() {
	
    }
    Ticket(Showtime showtime, Hall hall, TicketType type) {
	setShowtime(showtime);
	setHall(hall);
	setType(type);
    }
    Ticket(Showtime showtime, Hall hall, TicketType type, Seat seat) {
	setShowtime(showtime);
	setHall(hall);
	setType(type);
	setSeat(seat);
    }
    Ticket(Showtime showtime, Hall hall, TicketType type, Seat seat, Movie movie) {
	setShowtime(showtime);
	setHall(hall);
	setType(type);
	setSeat(seat);
	setMovie(movie);
    }
    
    // Getters
    Showtime getShowtime() {
	return showtime;
    }
    Hall getHall() {
	return hall;
    }
    TicketType getType() {
	return type;
    }
    Seat getSeat() {
	return seat;
    }
    int getSeatNum() {
	return seat.getSeatNum();
    }
    Movie getMovie() {
	return movie;
    }
    
    // Setters
    void setShowtime(Showtime showtime) {
	this.showtime = showtime;
    }
    void setHall(Hall hall) {
	this.hall = hall;
    }
    void setType(TicketType type) {
	this.type = type;
    }
    void setSeat(Seat seat) {
	this.seat = seat;
    }
    void setMovie(Movie movie) {
	this.movie = movie;
    }
    
} // Booking class

enum TicketType {
    CHILD, ADULT, SENIOR;
}
