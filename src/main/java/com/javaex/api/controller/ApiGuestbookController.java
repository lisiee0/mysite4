package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/api/guest")
public class ApiGuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	
	@RequestMapping("/addList")
	public String addList() {
		System.out.println("apiController/addList()");
		
		return "/aguestbook/addList";
	}
	
	
	@ResponseBody
	@RequestMapping("/list")
	public List<GuestbookVo> list() {
		System.out.println("apiController/list()");
		
		return guestbookService.getList();
	}
	
	@RequestMapping("/add")
	public void add() {
		
	}
}
