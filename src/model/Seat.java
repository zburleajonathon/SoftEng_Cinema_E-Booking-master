
package termproj;

public class Seat {
    int seatNum;
    int hallID;
    String hallName;
    
    // Constructors
    Seat() {
	
    }
    Seat(int seatNum) {
	setSeatNum(seatNum);
    }
    Seat(int seatNum, int hallID) {
	setSeatNum(seatNum);
	setHallID(hallID);
    }
    Seat(int seatNum, String hallName) {
	this.seatNum = seatNum;
	this.hallName = hallName;
    }

    // Getters
    int getSeatNum() {
	return seatNum;
    }
    int getHallID() {
	return hallID;
    }
    String getHallName() {
	return hallName;
    }

    // Setters
    void setSeatNum(int seatNum) {
	this.seatNum = seatNum;
    }
    void setHallID(int hallID) {
	this.hallID = hallID;
    }
    void setHallName(String hallName) {
	this.hallName = hallName;
    }
    
}
