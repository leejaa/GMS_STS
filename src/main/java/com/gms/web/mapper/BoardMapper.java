package com.gms.web.mapper;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gms.web.board.BoardDTO;


@Repository
public interface BoardMapper {
	public int insert(BoardDTO article);
	public List<BoardDTO> selectAll();
	public List<BoardDTO> selectById(String id);
	public BoardDTO selectBySeq(String seq);
	public int update(BoardDTO article);
	public int delete(String seq);
	public int count();
}
