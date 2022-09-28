package Airlines;

import java.io.File;
import java.util.Scanner;
/**
 * Run the reservation system program
 * @author Nishank Kuppa
 *
 */
public class ReservationSystem
{
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		// ReservationSystem newReservation = new ReservationSystem();
	
		Seating[][] theEconomy = null;
		Seating[][] theFirstClass = null;
		Reservation newReservation = new Reservation(theFirstClass, theEconomy);

		System.out.println(
				"Add [P]assenger, Add [G]roup, [C]ancel Reservations, Print Seating [A]vailability Chart, Print [M]anifest, [Q]uit");
		String characterSelection = userInput.nextLine();

		if (characterSelection.equalsIgnoreCase("P"))
		{
			newReservation.addPassenger();
		}

		else if (characterSelection.equalsIgnoreCase("G"))
		{
			newReservation.addGroup();
		}

		else if (characterSelection.equalsIgnoreCase("C"))
		{
			newReservation.cancelReservations();
		}

		else if (characterSelection.equalsIgnoreCase("A"))
		{
			newReservation.printSeatingAvailabilityChart();
		}

		else if (characterSelection.equalsIgnoreCase("M"))
		{
			newReservation.printManifest();
		}

		else if (characterSelection.equalsIgnoreCase("Q"))
		{
			newReservation.quitProgram();
		} 
		else
		{
			//System.out.println("Sorry, that is not a valid input.");
			System.out.println(theFirstClass);
		}
		userInput.close();
		// System.out.println(Arrays.deepToString(firstClass));

	}

}
