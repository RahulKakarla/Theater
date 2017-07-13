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
import com.rk.entity.Screen;

@Controller
public class ScreenCnt {

	@RequestMapping("/ScreenCnt")
	public ModelAndView getScreens(HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session=request.getSession();
		
		ViewTheaterDAO db=new ViewTheaterDAO();
		String name=request.getParameter("theater");
		session.setAttribute("Theater", name);
		ArrayList <Screen> th=new ArrayList<Screen>();
		try {
			th=db.viewScren(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView model=new ModelAndView("ViewScreen");
		model.addObject("Screens", th);
		return model;
		
	}
}
