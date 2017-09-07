package com.gms.web.member;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gms.web.command.CommandDTO;

@Repository
public interface MemberDao {
	public String insert(Map<?,?>map);
	public List<?> selectAll(CommandDTO cmd);
	public String count(CommandDTO cmd);
	public StudentBean selectById(CommandDTO cmd);
	public MemberDTO memberById(CommandDTO cmd);
	public List<StudentBean> selectByName(CommandDTO cmd);
	public String update(Map<?,?> map);
	public String delete(CommandDTO cmd);
	public String countByName(CommandDTO cmd);
	public MemberDTO login(CommandDTO cmd);
}
