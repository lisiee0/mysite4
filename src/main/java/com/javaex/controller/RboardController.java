package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.RboardService;
import com.javaex.vo.RboardVo;

@Controller
@RequestMapping("/rboard")
public class RboardController {
	
	@Autowired
	private RboardService rboardService;
	
	
	// 게시글 리스트
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("rboardController/list()");
		
		List<RboardVo> rList= rboardService.list();
		model.addAttribute("rList", rList);
		
		return "/board/rboard/list";
	}
	
	
	// 게시글 읽기
		@RequestMapping("/read")
		public String read(@RequestParam("no") int no, Model model) {
			System.out.println("rboardController/read()");
			
			RboardVo post= rboardService.post(no); // no번 게시글 선택
			rboardService.read(no); // 조회수 +1
			model.addAttribute("post", post);
			
			return "/board/rboard/read";
		}
		
	
	// 게시글 수정폼
	@RequestMapping("/modifyForm")
	public String modifyForm(@RequestParam("no") int no, Model model) {
		System.out.println("rboardController/modifyForm()");

		RboardVo post= rboardService.post(no);
		model.addAttribute("post", post);
		
		return "/board/rboard/modifyForm";
	}
	
	
	// 게시글 수정
	@RequestMapping("/modify")
	public String modify(@ModelAttribute RboardVo vo) {
		System.out.println("rboardController/modify()");
		
		rboardService.modify(vo);
	
		return "redirect:/rboard/list";
	}
	
	
	// 게시글 삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam("no") int no) {
		System.out.println("rboardController/delete()");
		
		rboardService.delete(no);
		
		return "redirect:/rboard/list";
	}
	
	
	// 글쓰기폼
	@RequestMapping("/writeForm")
	public String writeForm() {
		System.out.println("rboardController/writeForm()");
		
		return "/board/rboard/writeForm";
	}
	
	
	
}
