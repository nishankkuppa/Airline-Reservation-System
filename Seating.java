package Airlines;

/**
 * Each Seating object contains the passenger name, the location of the seat (ex: 12C), and the aisle that it's in (ex: W for window)
 * @author Nishank Kuppa
 *
 */
public class Seating
{
	private String passengerName;
	private String seatLocation;
	private String aisle;
	
	public Seating(String passengerName, String seatLocation, String aisle)
	{
		this.passengerName = passengerName;
		this.seatLocation = seatLocation;
		this.aisle = aisle;
	}
	
	public String getPassengerName()
	{
		return passengerName;
	}
	
	public String getSeatLocation()
	{
		return seatLocation;
	}
	
	public String getAisle()
	{
		return aisle;
	}
	
	public void setNewPassengerName(String newPassengerName)
	{
		passengerName = newPassengerName;
	}
	
	public void setNewSeatLocation(String newSeatLocation)
	{
		seatLocation = newSeatLocation;
	}
	
	public void setNewAisle(String newAisle)
	{
		aisle = newAisle;
	}
}
