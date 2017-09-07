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
		logger.info("move_write 진입..");
		return "board:board/write.tiles";
	}
	
	@RequestMapping("/move_list")
	public String goList(Model model) {
		logger.info("move_list 진입..");
		return "board:board/list.tiles";
	}
	
	@RequestMapping("/move_update")
	public String goUpdate(Model model) {
		logger.info("move_update 진입..");
		return "board:board/update.tiles";
	}
	
	@RequestMapping("/move_detail")
	public String goDetail(Model model) {
		logger.info("move_detail 진입..");
		return "board:board/detail.tiles";
	}
	
	@RequestMapping("/move_delete")
	public String goDelete(Model model) {
		logger.info("move_delete 진입..");
		return "/board/delete";
	}
}
