package com.rk.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SelectSeat {

	@RequestMapping("/SelectSeat")
	public ModelAndView selectSeat(HttpServletRequest request,HttpServletResponse response){

		int p=0;
		int price=Integer.parseInt(request.getParameter("price"));	
		List<String> seatid=Arrays.asList(request.getParameterValues("select"));
		HttpSession session=request.getSession();
		session.setAttribute("Seats", seatid);
		p=price*seatid.size();
		session.setAttribute("price", p);

		return new ModelAndView("PayPal");

	}
}
