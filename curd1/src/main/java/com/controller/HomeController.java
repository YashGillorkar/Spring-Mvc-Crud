package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Student;
import com.serviceI.StudentServiceI;


@Controller
public class HomeController {
	
	@Autowired
	StudentServiceI ssi;
	
	@RequestMapping("/")
	public String firstPg() {
		return "loginPg";
	}
	
	@RequestMapping("/openregisterpage")
	public String registerationPg() {
		
		return "registerPg";
	}
	
	@RequestMapping("/save")
	public String saveData(@ModelAttribute Student s) {
		ssi.saveData(s);
		return "loginPg";
	}
	
	
	@RequestMapping("/log")
	public String loginStudent(@RequestParam String username,@RequestParam String password,Model m)
	{
		System.out.println("in controller");
	List<Student> list=ssi.loginStudent(username,password);
	if(!list.isEmpty())
	{
		m.addAttribute("data",list);
		return "success";
	}
	else
	{
		m.addAttribute("msg","Invalid username and password");
		return"login";
	}
	
	}
	
	
	
}
