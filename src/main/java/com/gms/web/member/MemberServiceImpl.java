package com.gms.web.member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gms.web.command.CommandDTO;
import com.gms.web.grade.GradeDTO;
import com.gms.web.mapper.GradeMapper;
import com.gms.web.mapper.MemberMapper;
import com.gms.web.member.MemberDTO;

@Service 
public class MemberServiceImpl implements MemberService{
	@Autowired MemberMapper mapper;
	@Autowired MemberDTO member;
	@Autowired GradeMapper gMapper;
	@Autowired GradeDTO grade;
	
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {}
	@SuppressWarnings("unchecked")
	@Override @Transactional
	public int addMember(Map<?,?> map) {
		System.out.println("member service 진입..");
		int result=0;
		
		System.out.println("맵의 멤버 : "+map.get("member"));
		System.out.println("맵의 과목 : "+map.get("subjects"));
		System.out.println("날라온 맵 전체 : "+map);
		result=mapper.insert((MemberDTO)map.get("member"));
		
		List<StudentSubjectDTO> list=(List<StudentSubjectDTO>) map.get("subjects");
		System.out.println("list : "+list);
		result=gMapper.insertSubject(list);
		return result;
	}
	@Override
	public List<?> getMembers(CommandDTO cmd) {
		return mapper.selectAll(cmd);
	}
	@Override
	public String count() {
	      return mapper.count();
	}
	@Override
	public MemberDTO studentById(CommandDTO cmd) {
		return mapper.selectById(cmd);
	}
	@Override
	public List<MemberDTO> getMemberByName(CommandDTO cmd) {
		return mapper.selectByName(cmd);
	}
	@Override
	public int modify(Map<?,?> map) {
		return mapper.update(map);
	}
	@Override
	public int remove(CommandDTO cmd) {
		return mapper.delete(cmd);
	}
	@Override
	public Map<String,Object> login(CommandDTO command) {
		Map<String,Object> map=new HashMap<>();
		
		member=mapper.login(command);
		if(member==null) {
			map.put("message", "존재하지 않는 아이디입니다");
			map.put("view", "member:member/join.tiles");
		}else {
		
		if(member.getPassword().equals(command.getPassword())){
			map.put("message", "success");
			map.put("user", member);
			map.put("view", "public:common/home.tiles");
		}else {
			map.put("message", "비밀번호를 다시 입력해주세요");
			map.put("view", "public:member/login.tiles");
			}
		}
		return map;
	}
	
	@Override
	public String countMembersByName(CommandDTO cmd) {
		return null;
	}
}
