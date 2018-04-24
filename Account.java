/**
 * 
 * @author Alex Rooney CIS 152 Final Project
 * Account class stores all the information about the customer buying tickets
 *
 */
public class Account {

	private int accessCode;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String creditCard;
	private int ticketAmt;
	
	/**
	 * 
	 * @param code integer key identifier
	 * @param first string representing first name
	 * @param last string representing last name
	 * @param address string representing address
	 * @param city string representing city
	 * @param state string representing state
	 * @param zip string representing zip code
	 * @param ccCard string representing credit card number
	 * @param ticketAmt integer representing amount of tickets purchased
	 */
	public Account(int code, String first, String last, String address, String city, String state, String zip, String ccCard, int ticketAmt){
		this.accessCode = code;
		this.firstName = first;
		this.lastName = last;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.creditCard = ccCard;
		this.ticketAmt = ticketAmt;
	}

	/**
	 * @return the acctNum
	 */
	public int getAccessCode() {
		return accessCode;
	}

	/**
	 * @param acctNum the acctNum to set
	 */
	public void setAccessCode(int code) {
		this.accessCode = code;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 
	 * @return the zip code
	 */
	public String getZip(){
		return zip;
	}
	/**
	 * 
	 * @param zip the zipcode to set
	 */
	public void setZip(String zip){
		this.zip = zip;
	}

	/**
	 * @return the creditCard
	 */
	public String getCreditCard() {
		return creditCard;
	}

	/**
	 * @param creditCard the creditCard to set
	 */
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	/**
	 * 
	 * @return integer amount of purchased tickets
	 */
	public int getTicketAmt(){
		return ticketAmt;
	}
	/**
	 * 
	 * @param ticketAmt the integer amount of tickets sold
	 */
	public void setTicketAmt(int ticketAmt){
		this.ticketAmt = ticketAmt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accessCode=" + accessCode + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", city=" + city + ", state=" + state + ", zip=" + zip + ", creditCard=" + creditCard + ", ticketAmt=" + ticketAmt + "]";
	}
	
	
}
