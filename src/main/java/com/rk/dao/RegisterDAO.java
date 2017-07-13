package com.rk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import com.rk.entity.Register;

public class RegisterDAO {

	public void Register(Register rg,String unm,String pas,HttpSession session) throws SQLException{

		ConnectionDAO cd=new ConnectionDAO();
		Connection conn=cd.getConnection();
		Statement stmt=conn.createStatement();
		boolean i=true,j = true;
		String x="Insert into PayPal (Name,user_name,Mobile,account,amount) "
				+ "values('"+rg.getName()+"','"+unm+"','"
				+ ""+rg.getMobile()+"','"+rg.getAccount()+"',"+rg.getAmount()+")";
		String y="Insert into Login (user_name,password) values ('"+unm+"','"+pas+"')";
		i=stmt.execute(x);
		j=stmt.execute(y);
		if(i==false && j==false){
			session.setAttribute("db", "Created");
		}
		else{
			session.setAttribute("db", "Failed");
		}
		cd.connClose(conn);
	}

	public int check(String unm,String pas) throws SQLException{
		ConnectionDAO cd=new ConnectionDAO();
		Connection conn=cd.getConnection();
		int amount = 0;
		String x="Select p.amount from Login l join PayPal p on l.user_name=p.user_name "
				+ "where l.user_name=? and l.password=?";
		PreparedStatement pstmt=conn.prepareStatement(x);
		pstmt.setString(1,unm);
		pstmt.setString( 2,pas);
		ResultSet rs =pstmt.executeQuery();
		while (rs.next()){
			amount=rs.getInt("amount");
		}
		return amount;

	}
	public boolean checkUS(String unm) throws SQLException{
		ConnectionDAO cd=new ConnectionDAO();
		Connection conn=cd.getConnection();

		String x="Select * from Login where user_name=? ";
		PreparedStatement pstmt=conn.prepareStatement(x);
		pstmt.setString(1,unm);

		ResultSet rs =pstmt.executeQuery();
		return rs.next();

	}


}
