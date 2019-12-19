
package termproj;

public class PaymentInfo {
    String cardNumber;
    String name;
    String expiration;
    String cardType;
    String ccv;
    Address billing;
    String zip;
    

    // Constructors
    
    // using this one for registration and checkout
    PaymentInfo(String cc_num, String cc_name, String cc_exp, String cc_ccv) {
	//setCardNumber(cc_num);
	//setName(cc_name);
	//setExp(cc_exp);
	//setCvv(cc_cvv);
	this.cardNumber = cc_num;
	this.name = cc_name;
	this.expiration = cc_exp;
	this.ccv = cc_ccv;
    }
    PaymentInfo(String cc_num, String cc_name, String cc_exp, String cc_cvv, String zip) {	
	this.cardNumber = cc_num;
	this.name = cc_name;
	this.expiration = cc_exp;
	this.ccv = cc_cvv;
	this.zip = zip;
    }
    
    
    //using this contructor for checkout; check for null parameters in servlets 
    PaymentInfo(String cc_num, String cc_name, String cc_exp, String cardType, String cc_ccv, String zip) {
	//setCardNumber(cc_num);
	//setName(cc_name);
	//setExp(cc_exp);
	//setCvv(cc_cvv);
	this.zip = zip;
	this.cardNumber = cc_num;
	this.name = cc_name;
	this.expiration = cc_exp;
	this.cardType = cardType;
	this.ccv = cc_ccv;
    }
    //2nd option for checkout
    PaymentInfo(String cardNumber, String name, String exp, String cardType, String ccv, String street, String state, String country, String zip) {
	this.cardNumber = cardNumber;
	this.name = name;
	this.expiration = exp;
	this.cardType = cardType;
	this.ccv = ccv;
	this.billing = new Address(street, state, country, zip);
	//billing.setStreet(street);
	//billing.setState(state);
	//billing.setCountry(country);
	//billing.setZip(zip);
    }
    
    //getters
    Address getBillAddr() {
	return billing;
    }
    String getCardNumber(){
	return cardNumber;
    }
    String getName(){
	return name;
    }
    String getExpiration(){
	return expiration;
    }
    String getCardType(){
	return cardType;
    }
    String getCcv(){
	return ccv;	    
    }
    String getStreet(){
	return getBillAddr().getStreet();
    }
    String getState(){
	return getBillAddr().getState();
    }
    String getCountry(){
	return getBillAddr().getCountry();
    }
    String getZip(){
	return zip;
    }
    
    //setters
    void setCardNumber(String cardNumber){
	this.cardNumber = cardNumber;
    }
    void setName(String name){
	this.name = name;
    }
    void setExpiration(String expiration){	
	this.expiration = expiration;
    }
    void setCardType(String cardType){
	this.cardType = cardType;
    }
    void setCcv(String ccv) {
       this.ccv = ccv;
    }
	void setZip(String zip)
	{
		this.zip = zip;
	}
}
