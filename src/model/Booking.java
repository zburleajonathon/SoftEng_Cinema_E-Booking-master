
package termproj;

import java.util.ArrayList;

public class Booking {
    Customer customer;
    PaymentInfo payment;
    int confirmID;
    Promo promo;
    ArrayList<Ticket> tickets;
    Showtime showtime;
    boolean hasPromo;
    int numTickets;
    
    // Constructors
    Booking() {
	tickets = new ArrayList<Ticket>();
	numTickets = 0;
    }
    Booking(Customer customer, PaymentInfo payment, Showtime showtime) { // use this for checkout
	tickets = new ArrayList<Ticket>();
	setCustomer(customer);
	setShowtime(showtime);
	hasPromo = false;
	numTickets = 0;
    }
    Booking(Customer customer) {
	tickets = new ArrayList<Ticket>();
	setCustomer(customer);
	numTickets = 0;
    }
    
    void addTicket(Ticket ticket) {
	tickets.add(ticket);
	numTickets += 1;
    }
    void addTicket(Showtime showtime, Hall hall, TicketType type) {
	Ticket ticket = new Ticket(showtime, hall, type);
	tickets.add(ticket);
	numTickets += 1;
    }
    
    // Getters
    Customer getCustomer() {
	return customer;
    }
    int getConfirmID() {
	return confirmID;
    }
    Promo getPromo() {
	return promo;
    }
    ArrayList<Ticket> getTickets() {
	return tickets;
    }
    Ticket getTicket(int index) {
	return tickets.get(index);
    }
    Showtime getShowtime() {
	return showtime;
    }
    boolean hasPromo() {
	return hasPromo;
    }
    String getDate() {
	return showtime.getDate();
    }
    String getTime() {
	return showtime.getTime();
    }
    String getMovieName() {
	return showtime.getMovie().getName();
    }
    int getNumTickets() {
	return numTickets;
    }
    
    
    // Setters
    void setCustomer(Customer customer) {
	this.customer = customer;
    }
    void setConfirmID(int confirmID) {
	this.confirmID = confirmID;
    }
    void setPromo(Promo promo) {
	this.hasPromo = true;
	this.promo = promo;
    }
    void setShowtime(Showtime showtime) {
	this.showtime = showtime;
    }
    
} // Booking class

