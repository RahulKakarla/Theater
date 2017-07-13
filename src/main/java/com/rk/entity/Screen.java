package com.rk.entity;

public class Screen {
	public String ScreenType;
	public String TheaterName;
	public int ScreenNum;
	public int numofseats;
	public int numofrows;
	public int numofSeatsRow;
	public int numofTickets;
	public String getScreenType() {
		return ScreenType;
	}
	public String getTheaterName() {
		return TheaterName;
	}
	public void setTheaterName(String theaterName) {
		TheaterName = theaterName;
	}
	public void setScreenType(String screenType) {
		ScreenType = screenType;
	}
	public int getScreenNum() {
		return ScreenNum;
	}
	public void setScreenNum(int screenNum) {
		ScreenNum = screenNum;
	}
	public int getNumofseats() {
		return numofseats;
	}
	public void setNumofseats(int numofseats) {
		this.numofseats = numofseats;
	}
	public int getNumofrows() {
		return numofrows;
	}
	public void setNumofrows(int numofrows) {
		this.numofrows = numofrows;
	}
	public int getNumofSeatsRow() {
		return numofSeatsRow;
	}
	public void setNumofSeatsRow(int numofSeatsRow) {
		this.numofSeatsRow = numofSeatsRow;
	}
	public int getNumofTickets() {
		return numofTickets;
	}
	public void setNumofTickets(int numofTickets) {
		this.numofTickets = numofTickets;
	}
	
}
