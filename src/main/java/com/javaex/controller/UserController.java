package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Controller
@SessionAttributes("authUser") // 세션설정
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
	public String login(@ModelAttribute UserVo vo, Model model) {
		System.out.println("UserController/login()");
		
		UserVo authUser= ud.getUser(vo);
		System.out.println(authUser);
		
		if(authUser==null) { // 로그인 실패
			return "redirect:/user/loginForm?result=fail";
		}
		else { // 로그인 성공
			model.addAttribute("authUser", authUser); // model --> session
			return "redirect:/";
		}
	}
	
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(@SessionAttribute("authUser") UserVo vo, 
						SessionStatus sessionStatus) { 
		System.out.println("UserController/logout()");
	
		sessionStatus.setComplete(); // 세션 삭제
		
		return "redirect:/";
	}
	
	
	// 회원가입폼
	@RequestMapping("/joinForm")
	public String joinForm() {
		System.out.println("UserController/joinForm()");
		
		return "/user/joinForm";
	}
	
	
	// 회원가입
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo vo) {
		System.out.println("UserController/join");
		ud.userInsert(vo);
		
		return "/user/joinOk";
	}
	
	
	// 회원정보수정폼
	@RequestMapping("/modifyForm")
	public String modifyForm() {
		System.out.println("UserController/modifyForm");
		
		return "/user/modifyForm";
	}
	
	
	// 회원정보수정
	@RequestMapping("/modify")
	public String modify(@ModelAttribute UserVo vo, Model model) {
		System.out.println("UserController/modify");

		ud.userUpdate(vo); 

		UserVo authUser= ud.getUser(vo); // 수정된 정보의 authUser 재설정
		model.addAttribute("authUser", authUser); // 세션 덮어쓰기
		
		return "redirect:/";
	}	
}
