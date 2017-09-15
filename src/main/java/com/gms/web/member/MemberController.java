package com.gms.web.member;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gms.web.command.CommandDTO;
import com.gms.web.proxy.BlockHandler;
import com.gms.web.proxy.PageHandler;
import com.gms.web.proxy.PageProxy;


@Controller
@SessionAttributes({"user","student"})
@RequestMapping("member")
public class MemberController {
	@Autowired MemberDTO member;
	@Autowired MemberService service;
	@Autowired CommandDTO command;
	@Autowired BlockHandler blockHandler;
	@Autowired PageHandler pageHandler;
	@Autowired PageProxy pageProxy;
	@Autowired StudentSubjectDTO subject;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("member_id") String member_id,@RequestParam("password")String password,Model model,HttpSession session) {
		logger.info("login 진입..");
		logger.info("ID : "+member_id);
		logger.info("PASSWORD : "+password);
		command.setMember_id(member_id);
		command.setPassword(password);
		Map<String,Object> map=service.login(command);
		model.addAttribute("map",map);
		if(map.get("message").equals("success")) {
			model.addAttribute("user",map.get("user"));
			
		}
		return String.valueOf(map.get("view"));
	}
	
	@RequestMapping("/move_{page}")
	public String goPage(Model model,@PathVariable String page,@RequestParam(value="pageNumber",required=false) String pageNumber,
			@RequestParam(value="search",required=false)String search,@RequestParam(value="member_id",required=false)String member_id) {
		logger.info("move_"+page+" 진입..");
		List<MemberDTO> list=new ArrayList<>();
		
		if(page.equals("list")&&search.equals("null")) {
			list=(List<MemberDTO>) service.getMembers(command);
			System.out.println("리스트결과 : "+list);
			pageProxy.setPageNumber(Integer.parseInt(pageNumber));
			pageProxy.setPageSize(5);
			pageProxy.setBlockSize(5);
			pageProxy.setTheNumberOfRows(Integer.parseInt(service.count()));
			pageProxy=pageHandler.attr(pageProxy);
			System.out.println(pageProxy);
			command.setStartRow(pageProxy.getStartRow());
			command.setEndRow(pageProxy.getEndRow());
			pageProxy.execute(model, blockHandler.attr(pageProxy), (List<MemberDTO>) service.getMembers(command));
			
		}else if(page.equals("list")){
			command.setSearch(search);
			list=(List<MemberDTO>) service.getMemberByName(command);
			pageProxy.setPageNumber(Integer.parseInt(pageNumber));
			pageProxy.setPageSize(5);
			pageProxy.setBlockSize(5);
			pageProxy.setTheNumberOfRows(list.size());
			pageProxy=pageHandler.attr(pageProxy);
			System.out.println(pageProxy);
			command.setStartRow(pageProxy.getStartRow());
			command.setEndRow(pageProxy.getEndRow());
			pageProxy.execute(model, blockHandler.attr(pageProxy), list);
		}
		
		
		return "member:member/"+page+".tiles";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model,@RequestParam("member_id")String member_id) {
		logger.info("delete 진입...");
		command.setMember_id(member_id);
		int n=service.remove(command);
		
		System.out.println(n);
		return "redirect:/member/move_list?pageNumber=1&search=null";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model,@RequestParam("member_id")String member_id) {
		
		logger.info("detail 진입...");
		System.out.println("디테일 회원 아이디 : "+member_id);
		command.setMember_id(member_id);
		member=service.studentById(command);
		System.out.println("받아온 회원 정보 : "+member);
		model.addAttribute("student",member);
		
		return "member:member/detail.tiles";
	}
	
	@RequestMapping("/go_update")
	public String go_update(Model model) {
		return "member:member/update.tiles";
	}
	
	@RequestMapping("/update")
	public String update(Model model,
			@RequestParam("name")String name,@RequestParam("email")String email,
			@RequestParam("phone")String phone,@RequestParam("password")String password,@RequestParam("member_id")String member_id) {
		System.out.println("update 진입...");
		Map<String,String> map=new HashMap<String, String>();
		map.put("member_id", member_id);
		map.put("name", name);
		map.put("email", email);
		map.put("phone", phone);
		map.put("password", password);
		int n=service.modify(map);
		System.out.println(n);
		return "public:common/home.tiles";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/join")
	public String join(@ModelAttribute MemberDTO member,@RequestParam("subject") List<?> list) {
		member.setSubj_id(String.valueOf(list.get(0)));
		member.setSubjects(list);
		System.out.println("가입 회원 정보 : "+member);
		System.out.println("선택한 과목들 : "+list);
		List<StudentSubjectDTO> subjects=new ArrayList<>();
		for(String i : (List<String>)list) {
			subject=new StudentSubjectDTO();
			subject.setMember_id(member.getMember_id());
			subject.setSubj_id(i);
			subjects.add(subject);
		}
		System.out.println("subjects 리스트 : " +subjects);
		Map<String,Object> map=new HashMap<>();
		map.put("member", member);
		map.put("subjects", subjects);
		System.out.println("담긴 맵 : "+map);
		int n=service.addMember(map);
		String page="";
		System.out.println("등록결과 : "+n);
		if(n==0) {
			page="member:member/join.tiles";
		}else {
			page="public:common/home.tiles";
		}
		
		return page;
	}
	
	
}
