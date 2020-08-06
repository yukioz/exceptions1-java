package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	//Construtores
	
	public Reservation() {
		
	}
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	//Getters and Setters
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	//Get dates
	public Date getcheckIn() {
		return checkIn;
	}
	public Date getcheckOut() {
		return checkOut;
	}

	//Métodos
	
	public long duration() {
		
		//Converte tempo em data para milisegundos tipo long
		long diff = checkOut.getTime() - checkIn.getTime();
		//Converte tempo em milisegundos para dias tipo long
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updatedates(Date checkIn, Date checkOut) {
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;	
	}
	
	@Override
	public String toString() {
		
		return "Room "
				+ roomNumber
				+ ", checkIn: "
				+ sdf.format(checkIn)
				+ ", checkOut: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " night";
		
	}
	
	
}
