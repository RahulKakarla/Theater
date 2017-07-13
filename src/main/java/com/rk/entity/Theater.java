package com.rk.entity;

public class Theater {
	public String TheaterName;
	public int numofScreens;
	public int numofRows;
	public int numofSeats;
	public String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTheaterName() {
		return TheaterName;
	}
	public void setTheaterName(String theaterName) {
		TheaterName = theaterName;
	}
	public int getNumofScreens() {
		return numofScreens;
	}
	public void setNumofScreens(int numofScreens) {
		this.numofScreens = numofScreens;
	}
	public int getNumofRows() {
		return numofRows;
	}
	public void setNumofRows(int numofRows) {
		this.numofRows = numofRows;
	}
	public int getNumofSeats() {
		return numofSeats;
	}
	public void setNumofSeats(int numofSeats) {
		this.numofSeats = numofSeats;
	}

}
