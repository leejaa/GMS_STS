package com.gms.web.member;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gms.web.command.CommandDTO;
import com.gms.web.member.MemberDTO;
import com.gms.web.member.StudentBean;
@Component
public interface MemberService {
	public String addMember(Map<?,?> map);
	public List<?> getMembers(CommandDTO cmd);
	public String countMembers(CommandDTO cmd);
	public String countMembersByName(CommandDTO cmd);
	public StudentBean studentById(CommandDTO cmd);
	public MemberDTO memberById(CommandDTO cmd);
	public List<?> getMemberByName(CommandDTO cmd);
	public String modify(Map<?,?> map);
	public String remove(CommandDTO cmd);
	public MemberDTO login(CommandDTO cmd);
	
}
