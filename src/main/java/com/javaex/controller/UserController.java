package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDao ud;
	
	// 로그인폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("UserController/loginForm()");
		
		return "/user/loginForm";
	}
	
	
	// 로그인
	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo vo) {
		System.out.println("UserController/login()");
		
		UserVo authUser= ud.getUser(vo);
		System.out.println(authUser);
		
		return "";
	}
}
