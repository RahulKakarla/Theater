package com.rk.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rk.dao.RegisterDAO;
import com.rk.entity.Register;

@Controller
public class RegisterCnt {

	@RequestMapping("/RegisterCnt")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response) throws ServletException{
		Register rg=new Register();
		RegisterDAO db=new RegisterDAO();
		ModelAndView model;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");

			String pass = request.getParameter("password");

			md.update(pass.getBytes("UTF-8")); 

			byte[] passo = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < passo.length; i++) {
				sb.append(Integer.toString((passo[i] & 0xff) + 0x100, 16).substring(1));
			}
			String pas=new String(sb);
			String unm=request.getParameter("uname");
			int amount=Integer.parseInt(request.getParameter("amount"));
			rg.setName(request.getParameter("name"));
			rg.setMobile(request.getParameter("phone"));
			rg.setAccount(request.getParameter("acnt"));
			rg.setUser_name(unm);

			rg.setAmount(amount);
			HttpSession session1=request.getSession(); 
			if(db.checkUS(unm)){


				String msg="User Name exists";

				//response.sendRedirect("/Project/jsp/Register.jsp");
				model=new ModelAndView("PayPal","msg",msg);

				return model;
			}
			else{

				db.Register(rg, unm, pas,session1);
				if(session1.getAttribute("db").equals("Created")){
					session1.setAttribute("uname", unm);
					model=new ModelAndView("Pay","uname",unm);
					model.addObject("amount",amount);
					return model;
				}
				else{
					String msg="User Creation failed";
					model=new ModelAndView("PayPal","msg",msg);
					return model;				
				}
				//request.getRequestDispatcher("/jsp/Login.jsp").forward(request,response);

			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/LoginCnt")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){

		RegisterDAO db=new RegisterDAO();
		ModelAndView model;
		MessageDigest md;
		try {


			md = MessageDigest.getInstance("SHA-256");

			String pass = request.getParameter("pass");

			md.update(pass.getBytes("UTF-8")); 

			byte[] passo = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < passo.length; i++) {
				sb.append(Integer.toString((passo[i] & 0xff) + 0x100, 16).substring(1));
			}
			String pas=new String(sb);
			String unm=request.getParameter("uname");
			int x=db.check(unm, pas);
			HttpSession session=request.getSession();
			if(x!=0){
				session.setAttribute("uname", unm);
				model=new ModelAndView("Pay","uname",unm);
				model.addObject("amount",x);
				return model;
			}
			else{
				String msg="Login Failed";
				model=new ModelAndView("PayPal","msg",msg);
				return model;	
			}
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
}
