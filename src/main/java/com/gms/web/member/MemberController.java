package com.gms.web.member;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping("/move_list")
	public String goList(Model model) {
		logger.info("move_list 진입...");
		return "/member/list";
	}
	
	@RequestMapping("/move_login")
	public String goLogin(Model model) {
		logger.info("login_view 진입..");
		return "/member/login";
	}
	
	@RequestMapping("/move_update")
	public String goUpdate(Model model) {
		logger.info("move_update 진입..");
		return "/member/update";
	}
	
	@RequestMapping("/move_delete")
	public String goDelete(Model model) {
		logger.info("move_delete 진입..");
		return "/member/delete";
	}
	
	@RequestMapping("/move_join")
	public String goJoin(Model model) {
		logger.info("move_join 진입..");
		return "/member/join";
	}
	
}
