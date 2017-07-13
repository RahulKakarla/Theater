package com.rk.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rk.dao.ViewTheaterDAO;
import com.rk.entity.Theater;

@Controller
public class CustomerCnt {

	@RequestMapping("/customer")
	public ModelAndView customer(){
		ViewTheaterDAO db=new ViewTheaterDAO();
		ArrayList <Theater> th=new ArrayList<Theater>();
		try {
			th=db.view();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView model= new ModelAndView("User");
		model.addObject("Lists",th);
		return model;
		
	}
}
