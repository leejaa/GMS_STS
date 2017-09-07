package com.gms.web.board;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface BoardDao {
	public int insert(BoardDTO article);
	public List<BoardDTO> selectAll();
	public List<BoardDTO> selectById(String id);
	public BoardDTO selectBySeq(String seq);
	public int update(BoardDTO article);
	public int delete(String seq);
	public int count();
}
