
package termproj;

public class Hall {
    int hallID;
    int numSeats;
    String name;
    Seat[] seats;
    
    // Constructors
    Hall() {
	this.numSeats = 120;
	seats = new Seat[numSeats];
    }
    Hall(int hallID, String name) {
	this.numSeats = 120;
	seats = new Seat[numSeats];
	this.hallID = hallID;
	this.name = name;
    }
    Hall(String name) {
	this.numSeats = 120;
	seats = new Seat[numSeats];
	this.name = name;
    }

    // Getters
    int getHallID() {
	return hallID;
    }
    int getNumSeats() {
	return numSeats;
    }
    String getName() {
	return name;
    }
    Seat[] getSeats() {
	return seats;
    }

    // Setters
    void setHallID(int hallID) {
	this.hallID = hallID;
    }
    void setNumSeats(int numSeats) {
	this.numSeats = numSeats;
    }
    void setName(String name) {
	this.name = name;
    }

} // Hall
