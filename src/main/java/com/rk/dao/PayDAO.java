package com.rk.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.StringUtils;

public class PayDAO {

	public boolean book(String unm,int amt) throws SQLException{
		boolean i=true;
		ConnectionDAO cd=new ConnectionDAO();
		Connection conn=cd.getConnection();
		Statement stmt=conn.createStatement();
		String x="update PayPal set amount=(amount-"+amt+") where user_name='"+unm+"' ";

		i=stmt.execute(x);
		return i;
	}



	public void ticket(List<String> seatid, String theater, int scn,int amount,String unm) throws SQLException {
		ConnectionDAO cd=new ConnectionDAO();
		Connection conn=cd.getConnection();
		Statement stmt=conn.createStatement();
		String y=new String();
		for(String s:seatid){
			y=y+"'"+s+"',";
		}
		y = y.substring(0, y.length() - 1);
		String x="update seat s join theater t on t.theater_id=s.theater_id  set s.isavailable='N' "
				+ "where t.name='"+theater+"' and s.screen_id= "+scn+" and SeatId in("+y+") " ;

		stmt.execute(x);
		String z="update Screen s join theater t on t.theater_id=s.theater_id set s.seatsavail=s.seatsavail-"+seatid.size()+" "
				+ "where t.name='"+theater+"' and s.screenid= "+scn+" ";
		stmt.execute(z);

		String B="Select theater_id from theater where name= '"+theater+"'";
		ResultSet rs= stmt.executeQuery(B);
		int tht=0;
		while (rs.next()){
			tht=rs.getInt("theater_id");
		}
		String A="Insert into transaction(numTick,price,user_id,SeatNum,screenid,theater_id)"
				+ "values("+seatid.size()+","+amount+",'"+unm+"',\""+y+"\","+scn+","+tht+")";

		stmt.execute(A);

	}

}
