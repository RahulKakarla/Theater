package com.rk.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rk.entity.Screen;
import com.rk.entity.Seat;
import com.rk.entity.Theater;

public class ViewTheaterDAO {

	public ArrayList <Theater> view() throws SQLException{
		ConnectionDAO cd=new ConnectionDAO();
		Connection conn=cd.getConnection();
		Statement stmt=conn.createStatement();	
		ArrayList <Theater> th=new ArrayList<Theater>();
		String x="Select * from Theater ";
		ResultSet rs=stmt.executeQuery(x);
		while(rs.next()){
			Theater t=new Theater();
			t.setTheaterName(rs.getString("name"));
			t.setAddress(rs.getString("address"));
			th.add(t);
		}
		return th;
	}

	public ArrayList <Screen> viewScren(String thn) throws SQLException{
		ConnectionDAO cd=new ConnectionDAO();
		Connection conn=cd.getConnection();
		Statement stmt=conn.createStatement();	
		ArrayList <Screen> th=new ArrayList<Screen>();
		String x="Select t.name,S.screenid,S.SeatsAvail,S.sctype from Screen S "
				+ "join Theater t on S.theater_id=t.theater_id where t.name='"+thn+"'";
		ResultSet rs=stmt.executeQuery(x);
		while(rs.next()){
			Screen t=new Screen();
			t.setScreenNum(rs.getInt("screenid"));
			t.setNumofseats(rs.getInt("SeatsAvail"));
			t.setTheaterName(rs.getString("name"));
			th.add(t);
		}
		return th;
	}
	public ArrayList<Seat> viewSeat(String thn,int Scnum) throws SQLException{
		ConnectionDAO cd=new ConnectionDAO();
		Connection conn=cd.getConnection();
		Statement stmt=conn.createStatement();	
		ArrayList <Seat> se=new ArrayList<Seat>();
		String x="Select SeatId,rownum,IsAvailable from Seat S join Theater t on t.theater_id=S.theater_id "
				+ " where S.Screen_Id="+Scnum+" and t.name='"+thn+"'";
		ResultSet rs=stmt.executeQuery(x);
		while(rs.next()){
			Seat st=new Seat();
			st.setSeatID(rs.getString("SeatId"));
			st.setRownum(rs.getInt("rownum"));
			if(rs.getString("IsAvailable").equals("Y")){
				st.setAvialable(true);
			}
			else{
				st.setAvialable(false);
			}
			se.add(st);
		}
		return se;

	}


}
