package com.niit.shopper.controller;

import javax.enterprise.inject.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopper.model.Category;
import com.niit.shopper.model.product;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView showindex()
	{
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
	@RequestMapping("/home")
	public ModelAndView showhome()
	{
		System.out.println("index page2");
		ModelAndView mv =new ModelAndView("index");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView showloginpage()
	{
		System.out.println("login");
		ModelAndView mv =new ModelAndView("login");
		return mv;
	}
	@RequestMapping("/register")
	public ModelAndView showregisterpage()
	{
		System.out.println("register page");
		ModelAndView mv =new ModelAndView("register");
		return mv;
	}
	
	@RequestMapping("/contact")
	public ModelAndView showcontactpage()
	{
		ModelAndView mv =new ModelAndView("contactus");
		return mv;
	}

	@RequestMapping("/aboutus")
	public ModelAndView showaboutuspage()
	{
		ModelAndView mv =new ModelAndView("about");
		return mv;
	}
	
	
}
