package com.cms.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "loginController")
@RequestScoped
public class LoginController {
	String username;
	String password;
	
	public String login(){
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		try{
			request.login(this.username, this.password);
			
			if (request.isUserInRole("admin"))
				outcome = "admin";
			if (request.isUserInRole("cashier"))
				outcome = "cashier";
			if (request.isUserInRole("director"))
				outcome = "director";
			if (request.isUserInRole("guardian"))
				outcome = "guardian";
			if (request.isUserInRole("lecturer"))
				outcome = "lecturer";
			if (request.isUserInRole("manager"))
				outcome = "manager";
			if (request.isUserInRole("student"))
				outcome = "user";
			
			return outcome;
		} catch(ServletException e) {
			return "failure";
		}
	}
	
	public String logout(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return "logout";
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
