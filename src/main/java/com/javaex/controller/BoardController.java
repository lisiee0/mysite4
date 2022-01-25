package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	// 게시글 리스트
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("boardController/list()");
		List<BoardVo> bList= boardService.list();
		
		model.addAttribute("bList", bList);
		return "/board/list";
	}
	
	
	// 게시글 읽기
	@RequestMapping("/read")
	public String read(@RequestParam("no") int no, Model model) {
		System.out.println("boardController/read()");
		
		BoardVo post= boardService.post(no); // no번 게시글 선택
		boardService.read(no); // 조회수 +1
		model.addAttribute("post", post);
		
		return "/board/read";
	}
	
	
	// 게시글 수정폼
	@RequestMapping("/modifyForm")
	public String modifyForm(@RequestParam("no") int no, Model model) {
		System.out.println("boardController/modifyForm()");

		BoardVo post= boardService.post(no);
		model.addAttribute("post", post);
		
		return "/board/modifyForm";
	}
	
	
	// 게시글 수정
	@RequestMapping("/modify")
	public String modify(@ModelAttribute BoardVo vo) {
		System.out.println("boardController/modify()");
		
		boardService.modify(vo);
	
		return "redirect:/board/list";
	}
	
	
	// 게시글 삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam("no") int no) {
		System.out.println("boardController/delete()");
		
		boardService.delete(no);
		
		return "redirect:/board/list";
	}
	
	
	// 글쓰기폼
	@RequestMapping("/writeForm")
	public String writeForm() {
		System.out.println("boardController/writeForm()");
		
		return "/board/writeForm";
	}
	
	
	// 글쓰기
	@RequestMapping("/write")
	public String write(@ModelAttribute BoardVo vo) {
		System.out.println("boardController/write()");
		
		boardService.write(vo);
		
		return "redirect:/board/list";
	}
	
}