package com.gms.web.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gms.web.command.CommandDTO;
import com.gms.web.member.MemberDTO;

@Repository
public interface MemberMapper {
	public int insert(MemberDTO member);
	public List<?> selectAll(CommandDTO cmd);
	public String count();
	public MemberDTO selectById(CommandDTO cmd);
	public MemberDTO memberById(CommandDTO cmd);
	public List<MemberDTO> selectByName(CommandDTO cmd);
	public int update(Map<?,?> map);
	public int delete(CommandDTO cmd);
	public String countByName(CommandDTO cmd);
	public MemberDTO login(CommandDTO command);
}
