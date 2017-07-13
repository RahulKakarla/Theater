package com.rk.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rk.dao.ViewTheaterDAO;
import com.rk.entity.Seat;

@Controller
public class SeatShow {

	@RequestMapping("/SeatShow")
	public ModelAndView showSeat(HttpServletRequest request,HttpServletResponse response){
		ViewTheaterDAO db=new ViewTheaterDAO();
		HttpSession session=request.getSession();
		
		String thn=request.getParameter("theater");
		
		int Scnnum=Integer.parseInt(request.getParameter("screen"));
		session.setAttribute("screen", Scnnum);
		int tickets=Integer.parseInt(request.getParameter(request.getParameter("screen")));
		ArrayList<Seat> st=new ArrayList<Seat>();
		try {
			st=db.viewSeat(thn, Scnnum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView model=new ModelAndView("ViewSeat");
		model.addObject("Seats", st);
		model.addObject("num", tickets);
		return model;
		
	}
}
