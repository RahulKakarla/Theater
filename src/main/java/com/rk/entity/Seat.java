package com.rk.entity;

public class Seat {
	public String SeatID;
	public int rownum;
	public boolean isAvialable;
	public String getSeatID() {
		return SeatID;
	}
	public void setSeatID(String seatID) {
		SeatID = seatID;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public boolean isAvialable() {
		return isAvialable;
	}
	public void setAvialable(boolean isAvialable) {
		this.isAvialable = isAvialable;
	}
	

}
