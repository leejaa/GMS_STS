package com.gms.web.member;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gms.web.command.CommandDTO;
import com.gms.web.member.MemberDTO;
import com.gms.web.member.StudentBean;

@Service
public class MemberServiceImpl implements MemberService{
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {}
	@Override
	public String addMember(Map<?,?> map) {
		return null;
	}
	@Override
	public List<?> getMembers(CommandDTO cmd) {
		return null;
	}
	@Override
	public String countMembers(CommandDTO cmd) {
		return null;
	}
	@Override
	public StudentBean studentById(CommandDTO cmd) {
		return null;
	}
	@Override
	public List<StudentBean> getMemberByName(CommandDTO cmd) {
		return null;
	}
	@Override
	public String modify(Map<?,?> map) {
		return null;
	}
	@Override
	public String remove(CommandDTO cmd) {
		return null;
	}
	@Override
	public MemberDTO login(CommandDTO cmd) {
		return null;
	}
	@Override
	public MemberDTO memberById(CommandDTO cmd) {
		return null;
	}
	@Override
	public String countMembersByName(CommandDTO cmd) {
		return null;
	}
}
