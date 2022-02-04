package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("galleryController/list()");
		
		model.addAttribute("gList", galleryService.getList());
		return "/gallery/list";
	}
	
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, 
						 @ModelAttribute GalleryVo vo,
						 Model model) {
		System.out.println("galleryController/upload()");
	
		galleryService.restore(file, vo);
		return "redirect:/gallery/list";
	}

}