package Airlines;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Nishank Kuppa
 *
 */
public class Reservation
{
	Seating[][] firstClass = new Seating[2][4];
	Seating[][] economy = new Seating[20][6];
	
	//private Seating[][] firstClass;
	//private Seating[][] economy;

	public Reservation(Seating[][] firstClass, Seating[][] economy)
	{
		this.firstClass = firstClass;
		this.economy = economy;
		/*
		firstClass[0][0].setNewAisle("W");
		firstClass[0][1].setNewAisle("A");
		firstClass[0][2].setNewAisle("A");
		firstClass[0][3].setNewAisle("W");

		firstClass[1][0].setNewAisle("W");
		firstClass[1][1].setNewAisle("A");
		firstClass[1][2].setNewAisle("A");
		firstClass[1][3].setNewAisle("W");
		*/
	}
	/**
	 * Add a single passenger to the airplane seating
	 * @return seat name
	 */
	public String addPassenger()
	{
		Scanner addNewPassenger = new Scanner(System.in);

		System.out.println("Enter a passenger name: ");
		String passengerName = addNewPassenger.nextLine();

		System.out.println("Enter a preferred service class (first or economy): ");
		String serviceClass = addNewPassenger.nextLine();

		System.out.println("Enter a seat preference (W or A for first. W, C, or A for economy): ");
		String seatPreference = addNewPassenger.nextLine();

		if (serviceClass.equalsIgnoreCase("first"))															// if the selected service class is FIRST
		{
			for (int row = 0; row < firstClass.length; row++)									 			// for every row in the first class 2D array
			{
				for (int column = 0; column < firstClass[row].length; column++) 								// for every column (element) in the row
				{
					if (firstClass[row][column].getAisle().equalsIgnoreCase("W")							// if the seat is a window seat and the seat preference is a window seat
							&& seatPreference.equalsIgnoreCase("W"))
					{
						firstClass[row][column].setNewPassengerName(passengerName);							// add the passenger to that seat
						return new String (passengerName + " is seated in " + firstClass[row][column]);		// return the name and the assigned seat
					}

					else if (firstClass[row][column].getAisle().equalsIgnoreCase("A")						//  if the seat is an aisle seat and the seat preference is an aisle seat
							&& seatPreference.equalsIgnoreCase("A"))
					{
						firstClass[row][column].setNewPassengerName(passengerName);							// add the passenger to that seat
						return new String (passengerName + " is seated in " + firstClass[row][column]);		// return the name and the assigned seat
					}
				}
			}
		}

		else if (serviceClass.equalsIgnoreCase("economy"))
		{
			for (int row = 0; row < economy.length; row++) // for every row in the 2D array
			{
				for (int column = 0; column < economy[0].length; column++) // for every column (element) in the row
				{
					if (economy[row][column].getAisle().equalsIgnoreCase("W")							// if the seat is a window seat and the seat preference is a window seat
							&& seatPreference.equalsIgnoreCase("W"))
					{
						economy[row][column].setNewPassengerName(passengerName);							// add the passenger to that seat
						return new String (passengerName + " is seated in " + economy[row][column]);		// return the name and the assigned seat
					}
					
					else if (economy[row][column].getAisle().equalsIgnoreCase("C")						//  if the seat is a center seat and the seat preference is a center seat
							&& seatPreference.equalsIgnoreCase("C"))
					{
						economy[row][column].setNewPassengerName(passengerName);							// add the passenger to that seat
						return new String (passengerName + " is seated in " + economy[row][column]);		// return the name and the assigned seat
					}
					
					else if (economy[row][column].getAisle().equalsIgnoreCase("A")						//  if the seat is an aisle seat and the seat preference is an aisle seat
							&& seatPreference.equalsIgnoreCase("A"))
					{
						economy[row][column].setNewPassengerName(passengerName);							// add the passenger to that seat
						return new String (passengerName + " is seated in " + economy[row][column]);		// return the name and the assigned seat
					}
				}
			}
		}
		addNewPassenger.close();
		// System.out.println(passengerName);
		// System.out.println(serviceClass);
		// System.out.println(seatPreference);

		
		return new String ("Sorry, there are no available seats.");
	}

	/**
	 * Ask for group name, names of each member, and service class. Print seat
	 * numbers or "Request failed."
	 */
	public void addGroup()
	{
		Scanner addNewGroup = new Scanner(System.in);

		System.out.println("Enter a group name: ");
		String groupName = addNewGroup.nextLine();

		System.out.println("Enter the names of the group's members, separated by just a comma: ");
		String groupMembers = addNewGroup.nextLine();

		System.out.println("Enter a preferred service class (first or economy): ");
		String serviceClass = addNewGroup.nextLine();

		// parse group names into individual seats
		String delimiter = ",";
		String[] groupMembersAsArray = groupMembers.split(delimiter);
		/*
		for (int i = 0; i < groupMembersAsArray.length; i++) 
		{
			System.out.println(groupMembersAsArray[i]);
		}
		*/
		
		if (serviceClass.equalsIgnoreCase("first"))
		{
			for (int row = 0; row < firstClass.length; row++)									 			// for every row in the first class 2D array
			{
				for (int column = 0; column < firstClass[0].length; column++) 								// for every column (element) in the row
				{
					int count = 0;
					while (count < groupMembersAsArray.length)
					{
						firstClass[row][column].setNewPassengerName(groupMembersAsArray[count++]);
					}
				}
			}
		}
		else if (serviceClass.equalsIgnoreCase("economy"))
		{
			for (int row = 0; row < economy.length; row++)									 			// for every row in the first class 2D array
			{
				for (int column = 0; column < economy[0].length; column++) 								// for every column (element) in the row
				{
					if (economy[row][column].getPassengerName().equalsIgnoreCase(null))
					{
						int count = 0;
						while (count < groupMembersAsArray.length)
						{
							economy[row][column].setNewPassengerName(groupMembersAsArray[count++]);
						}
					}
				}
			}
		}
		
		
		addNewGroup.close();
	}

	/**
	 * Ask if cancellation is for an individual or group. If individual, ask for
	 * name. If group, ask for group name. Free up the corresponding spaces.
	 */
	public String cancelReservations()
	{
		Scanner cancellation = new Scanner(System.in);

		System.out.println("Enter the cancellation type (individual or group): ");
		String cancellationType = cancellation.nextLine();

		if (cancellationType.equalsIgnoreCase("individual"))
		{
			System.out.println("Enter the passenger name: ");
			String passengerName = cancellation.nextLine();
			// remove corresponding name from array
		}

		else if (cancellationType.equalsIgnoreCase("group"))
		{
			System.out.println("Enter the group name: ");
			String groupName = cancellation.nextLine();
			// remove corresponding names from array
		}

		else
		{
			System.out.println("Sorry, that is not a valid input");
			cancelReservations();
		}

		// remove corresponding name or group from array

		cancellation.close();
		return null;
	}

	/**
	 * Ask for service class. Print 2D array of names.
	 */
	public String printSeatingAvailabilityChart()
	{
		Scanner availability = new Scanner(System.in);

		System.out.println("Enter the class for the chart you want to see (first or economy): ");
		String classChoice = availability.nextLine();
		
		if (classChoice.equalsIgnoreCase("first"))
		{
			for (int row = 0; row < firstClass.length; row++)									 			// for every row in the first class 2D array
			{
				for (int column = 0; column < firstClass[0].length; column++) 								// for every column (element) in the row
				{
					return new String (firstClass[row][column].getSeatLocation());
				}
			}
		}
		else if (classChoice.equalsIgnoreCase("economy"))
		{
			for (int row = 0; row < economy.length; row++)									 			// for every row in the first class 2D array
			{
				for (int column = 0; column < economy[0].length; column++) 								// for every column (element) in the row
				{
					return new String (economy[row][column].getSeatLocation());
				}
			}
		}
		
		availability.close();
		return new String ("Invalid input, please try again");

	}

	/**
	 * Ask for service class. Print manifest. A manifest lists the occupied seats
	 * and the passengers seated in them.
	 */
	public String printManifest()
	{
		Scanner manifest = new Scanner(System.in);

		System.out.println("Enter the class for the chart you want to see (first or economy): ");
		String classChoice = manifest.nextLine();

		if (classChoice.equalsIgnoreCase("first"))
		{
			for (int row = 0; row < firstClass.length; row++) // for every row in the 2D array
			{
				for (int column = 0; column < firstClass[0].length; column++) // for every column (element) in the row
				{
					return new String (row + column + ": " + firstClass[row][column]);
				}
			}
		}

		else if (classChoice.equalsIgnoreCase("economy"))
		{
			for (int row = 0; row < economy.length; row++) // for every row in the 2D array
			{
				for (int column = 0; column < economy[0].length; column++) // for every column (element) in the row
				{
					return new String (row + column + ": " + economy[row][column]);
				}
			}
		}
		
		return null;
	}

	/**
	 * Save reservations in text file
	 * @throws FileNotFoundException 
	 */
	public String quitProgram() 
	{
		System.out.println("Saving to text file...");
		PrintWriter out;
		try
		{
			out = new PrintWriter("input.txt");
			out.println(firstClass);
			out.println(economy);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	
		return new String("Done");
	}
	

}
