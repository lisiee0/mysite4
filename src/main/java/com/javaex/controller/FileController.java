package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fileupload")
public class FileController {
	
	
	@RequestMapping("/form")
	public String form() {
		System.out.println("fileController/form()");
		
		return "/fileupload/form";
	}
	

}
