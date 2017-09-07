package com.gms.web.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.member.MemberController;

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/move_write")
	public String goWrite(Model model) {
		return "/board/write";
	}
	
	@RequestMapping("/move_list")
	public String goList(Model model) {
		return "/board/list";
	}
	
	@RequestMapping("/move_update")
	public String goUpdate(Model model) {
		return "/board/update";
	}
	
	@RequestMapping("/move_detail")
	public String goDetail(Model model) {
		return "/board/detail";
	}
	
	@RequestMapping("/move_delete")
	public String goDelete(Model model) {
		return "/board/delete";
	}
}
