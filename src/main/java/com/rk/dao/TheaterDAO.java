package com.rk.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rk.entity.Theater;

public class TheaterDAO {

	public void addTheater(Theater th) throws SQLException{

		int ID=insertTheater(th);

		if(ID!=0){
			insertSeat(ID, th.numofScreens, th.numofRows, th.numofSeats);
		}
		else{

		}

	}

	public static int insertTheater(Theater th) throws SQLException{
		ConnectionDAO cd=new ConnectionDAO();
		Connection conn=cd.getConnection();
		Statement stmt=conn.createStatement();	
		int ID = 0;
		String X= "Insert into theater (name ,noofScreens,noofrows,noofseats,address) "
				+ "values('"+th.TheaterName+"',"+th.numofScreens+","+th.numofRows+","+th.numofSeats+",'"+th.address+"')";
		stmt.execute(X);
		String Y="Select Theater_id from theater where name='"+th.TheaterName+"'";
		ResultSet rs=stmt.executeQuery(Y);
		if(rs.next()){
			ID=rs.getInt("Theater_id");
		}
		return ID;
	}
	public static void insertSeat(int thId,int numSC,int numofRows, int numofSeats ) throws SQLException{
		ConnectionDAO cd=new ConnectionDAO();
		Connection conn=cd.getConnection();
		Statement stmt=conn.createStatement();	
		for(int i=0;i<numSC;i++){
			String Z="Insert into Screen (ScreenId,Theater_Id,numofRows,numofSeats,SeatsAvail)"
					+ "values("+(i+1)+","+thId+","+numofRows+","+numofSeats+","+(numofRows*numofSeats)+")";
			stmt.execute(Z);
			for(int j=0;j<numofRows;j++){
				String y=String.valueOf((char)(j+1 + 64));

				for(int k=0;k<numofSeats;k++){

					String X= "Insert into Seat (Theater_id ,Screen_id,rownum,seatnum,SeatId,IsAvailable) "
							+ "values("+thId+","+(i+1)+","+(j+1)+","+(k+1)+",'"+(y+(k+1))+"','Y')";
					stmt.execute(X);

				}
			}
		}

	}
}
