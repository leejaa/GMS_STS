package com.gms.web.member;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.gms.web.command.CommandDTO;
import com.gms.web.member.MemberDTO;
@Component
public interface MemberService {
	public int addMember(Map<?,?> map);
	public List<?> getMembers(CommandDTO cmd);
	public String count();
	public String countMembersByName(CommandDTO cmd);
	public MemberDTO studentById(CommandDTO cmd);
	public List<?> getMemberByName(CommandDTO cmd);
	public int modify(Map<?,?> map);
	public int remove(CommandDTO cmd);
	public Map<String,Object> login(CommandDTO command);
}
