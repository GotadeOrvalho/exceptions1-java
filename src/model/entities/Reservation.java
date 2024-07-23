package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Reservation {
	private Integer roomNumber;
	private LocalDate chekIn;
	private LocalDate chekOut;
	
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public LocalDate getChekIn() {
		return chekIn;
	}
	
	public LocalDate getChekOut() {
		return chekOut;
	}
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, LocalDate chekIn, LocalDate chekOut) {
	
		this.roomNumber = roomNumber;
		this.chekIn = chekIn;
		this.chekOut = chekOut;
	}
	
	public long duration() {
		Duration c = Duration.between(chekIn.atStartOfDay(), chekOut.atStartOfDay());
		
		return c.toDays();
		
	}
	
	public String updateDates(LocalDate chekIn, LocalDate chekOut) {
		LocalDate now = LocalDate.now();

		if (chekIn.isBefore(now) || chekOut.isBefore(now)) {
			
			return "Reservations dates for update must be future dates.";
		} 
		if (!chekOut.isAfter(chekIn)) {
			
			return "Chek-out date must be after chek-in date.";
		}
			
		this.chekIn = chekIn;
		this.chekOut = chekOut;
		return null;		
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", chek-in: "
				+ dtf.format(this.chekIn)
				+ ", chek-out: "
				+ dtf.format(this.chekOut)
				+ ", "
				+ duration()
				+ " nights";
	}
}
