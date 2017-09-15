package com.gms.web.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.member.MemberController;

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/move_{page}")
	public String goPage(Model model,@PathVariable String page) {
		logger.info("move_"+page+" 진입..");
		return "board:board/"+page+".tiles";
	}
}
