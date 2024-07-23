package aplication;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		System.out.println("Room number: ");
		Integer number = sc.nextInt();
		System.out.println("Chek-in date (DD/MM/YYYY): ");
		sc.nextLine();
		LocalDate in = LocalDate.parse(sc.nextLine(), dtf);
		System.out.println("Chek-out date (DD/MM/YYYY): ");
		LocalDate out = LocalDate.parse(sc.nextLine(), dtf);

		if (!out.isAfter(in)) {
			System.out.println("Error in reservation: Chek-out date must be after chek-in date.");
		} else {
			Reservation a = new Reservation(number, in, out);
			System.out.println("Reservation: " + a);

			System.out.println(" ");

			System.out.println("Enter data to update the reservations: ");
			System.out.println("Chek-in date (DD/MM/YYYY): ");
			
			in = LocalDate.parse(sc.nextLine(), dtf);
			System.out.println("Chek-out date (DD/MM/YYYY): ");
			out = LocalDate.parse(sc.nextLine(), dtf);

			LocalDate now = LocalDate.now();

			if (in.isBefore(now) || out.isBefore(now)) {
				
				System.out.println("Error in reservation: Reservations dates for update must be future dates.");
			} else if (!out.isAfter(in)) {
				
				System.out.println("Error in reservation: Chek-out date must be after chek-in date.");
			} else {
				a.updateDates(in, out);

				System.out.println("Reservation: " + a);
			}

		}

		sc.close();

	}

}
