package aplication;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Room number: ");
			Integer number = sc.nextInt();
			System.out.println("Chek-in date (DD/MM/YYYY): ");
			sc.nextLine();
			LocalDate in = LocalDate.parse(sc.nextLine(), dtf);
			System.out.println("Chek-out date (DD/MM/YYYY): ");
			LocalDate out = LocalDate.parse(sc.nextLine(), dtf);
	
			Reservation a = new Reservation(number, in, out);
			System.out.println("Reservation: " + a);
	
			System.out.println(" ");
	
			System.out.println("Enter data to update the reservations: ");
			System.out.println("Chek-in date (DD/MM/YYYY): ");
	
			in = LocalDate.parse(sc.nextLine(), dtf);
			System.out.println("Chek-out date (DD/MM/YYYY): ");
			out = LocalDate.parse(sc.nextLine(), dtf);
	
			a.updateDates(in, out);
		
		System.out.println("Reservation: " + a);
		} 
		catch (DateTimeParseException e) {
			System.out.println("Invalid date format.");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error.");
		}

	
		sc.close();

	}

}
