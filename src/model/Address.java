
package termproj;

public class Address {
    String street;
    String city;
    String zip;
    String state;
    String country;



    Address(String street, String zip, String state, String country) {
	this.street = street;
	this.zip = zip;
	this.state = state;
	this.country = country;
    }
    
    //Constructors
    /*
	Address(String street, String state, String country, String zip) {
	this.street = street;
	this.country = country;
	this.zip = zip;
	this.state = state;
    }*/

    Address() {
	zip = "-1";
    }

    //getters
    String getStreet() {
	return street;
    }

    String getCountry() {
	return country;
    }

    String getZip() {
	return zip;
    }

    String getState() {
	return state;
    }
    String getCity() {
	return city;
    }

    //setters
    void setStreet(String street) {
	this.street = street;
    }

    void setCountry(String country) {
	this.country = country;
    }

    void setZip(String zip) {
	this.zip = zip;
    }

    void setState(String state) {
	this.state = state;
    }
    void setCity(String city) {
	this.city = city;
    }
}
