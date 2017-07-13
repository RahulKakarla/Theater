package com.rk.controller;

import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.rk.dao.PayDAO;


@Controller
public class PayCnt {

	@RequestMapping("/PayCnt")
	public ModelAndView pay(HttpServletRequest request,HttpServletResponse response){
		PayDAO db=new PayDAO();
		ModelAndView model;
		HttpSession session=request.getSession();

		String uname=(String)session.getAttribute("uname");
		int scn=(Integer)session.getAttribute("screen");
		String theater=(String)session.getAttribute("Theater");
		List<String> seatid =(List<String>) session.getAttribute("Seats");
		int amount=(Integer)session.getAttribute("price");

		System.out.println(amount);
		try {

			if(!db.book(uname, amount)){

				db.ticket(seatid,theater,scn,amount,uname);
				model=new ModelAndView("Ticket");
				return model;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}
}
