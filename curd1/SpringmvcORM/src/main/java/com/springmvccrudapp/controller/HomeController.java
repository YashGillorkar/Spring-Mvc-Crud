package com.springmvccrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvccrudapp.model.Student;
import com.springmvccrudapp.service_interface.StudentServiceI;

@Controller
public class HomeController {
	@Autowired
	StudentServiceI si;
 
	@RequestMapping("/")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/reg")
	public String reg()
	{
		return "Register";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Student s)
	{
		System.out.println("in controller");
		si.saveStudent(s);
		System.out.println("out controller");
		return "login";
		
	}
	
	@RequestMapping("/login")
	public String loginStudent(@RequestParam String username,@RequestParam String password,Model m)
	{
		System.out.println("in controller");
	List<Student> list=si.stulogin(username,password);
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
