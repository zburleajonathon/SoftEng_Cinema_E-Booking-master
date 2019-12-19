
package termproj;

public class Customer extends User {
    String firstName;
    String lastName;
    String password;
    String email;
    String phoneNumber;
    Address address;
    PaymentInfo paymentInfo;
    boolean subToPromo;
	// Status status;

    
    // Constructor with only required info
    Customer(String firstName, String lastName, String email, String password) 
	{ 
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
    }
    // Constructor with only required info and boolean subToPromo
    Customer(String firstName, String lastName, String email, String password, boolean subToPromo) 
	{ 
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setSubToPromo(subToPromo);
    }
    //Constructor with all parameters set for a new user
    Customer(String firstName, String lastName, String email, String password,
	     Address address, PaymentInfo paymentInfo, String phoneNum, boolean subToPromo) 
	{
		setFirstName(firstName);
		setPhoneNumber(phoneNum);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setAddress(address);
		setPaymentInfo(paymentInfo);
		setSubToPromo(subToPromo);
    }

    //Constructor with all parameters set for a new user except subToPromo
    Customer(String firstName, String lastName, String email, String password,
	     Address address, PaymentInfo paymentInfo, String phoneNum) 
	{
		setFirstName(firstName);
		setPhoneNumber(phoneNum);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setAddress(address);
		setPaymentInfo(paymentInfo);
    }
    
    
    // GETTERS
    
    String getFirstName() 
	{
		return firstName;
    }
    String getLastName() 
	{
		return lastName;
    }
    String getPassword() 
	{
		return password;
    }    
    String getEmail() 
	{
		return email;
    }
    String getPhoneNumber() 
	{
		return phoneNumber;
    }
    Address getAddress() 
	{
		return address;
    }
    PaymentInfo getPaymentInfo() 
	{
		return paymentInfo;
    }
	boolean getSubToPromo()
	{
		return subToPromo;
	}
    
    // SETTERS
    
    void setFirstName(String firstName) 
	{
		this.firstName = firstName;
    }
    void setLastName(String lastName) 
	{
		this.lastName = lastName;
    }
    void setPassword(String password) 
	{
		this.password = password;
    }
    void setEmail(String email) 
	{
		this.email = email;
    }
    void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
    }
    void setAddress(Address address) 
	{
		this.address = address;
    }
    void setPaymentInfo(PaymentInfo paymentInfo) 
    {
	this.paymentInfo = paymentInfo;
    }  
    void setSubToPromo(boolean subToPromo)
    {
	this.subToPromo = subToPromo;	
    }
    
}
