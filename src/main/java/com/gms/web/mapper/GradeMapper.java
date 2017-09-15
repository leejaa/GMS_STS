package com.gms.web.mapper;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.gms.web.member.StudentSubjectDTO;




@Repository
public interface GradeMapper {
	public int insertSubject(List<StudentSubjectDTO> list);
}
