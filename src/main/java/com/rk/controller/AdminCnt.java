package com.rk.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rk.dao.TheaterDAO;
import com.rk.entity.Theater;

@Controller
public class AdminCnt {

	@RequestMapping("/AdminCnt")
	public ModelAndView admin(HttpServletRequest request,HttpServletResponse response){
		Theater th=new Theater();
		TheaterDAO td=new TheaterDAO();
		th.TheaterName=request.getParameter("theatername");
		th.numofScreens=Integer.parseInt(request.getParameter("screens"));
		th.numofRows=Integer.parseInt(request.getParameter("rows"));
		th.numofSeats=Integer.parseInt(request.getParameter("seats"));
		th.address=request.getParameter("address");
		try {
			td.addTheater(th);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ModelAndView("Success");

	}
}
