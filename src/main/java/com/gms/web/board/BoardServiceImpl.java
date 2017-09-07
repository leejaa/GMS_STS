package com.gms.web.board;

import java.util.List;


public class BoardServiceImpl implements BoardService{
	public static BoardServiceImpl getInstance(){
		return new BoardServiceImpl();
	}
	public String write(BoardDTO article) {
		return BoardDaoImpl.getInstance().insert(article)==0?"존재하지 않는 아이디입니다":"등록성공";
	}

	@Override
	public List<BoardDTO> getArticles() {
		return BoardDaoImpl.getInstance().selectAll();
	}

	@Override
	public List<BoardDTO> findById(String id) {
		return BoardDaoImpl.getInstance().selectById(id);
	}

	@Override
	public BoardDTO findBySeq(String seq) {
		return BoardDaoImpl.getInstance().selectBySeq(seq);
	}

	@Override
	public String modify(BoardDTO article) {
		return BoardDaoImpl.getInstance().update(article)==0?"수정하고자하는 글번호가 존재하지 않습니다":"글수정성공";
	}

	@Override
	public String remove(String seq) {
		return BoardDaoImpl.getInstance().delete(seq)==0?"글번호가 존재하지 않습니다":"삭제성공";
	}

	@Override
	public int count() {
		return BoardDaoImpl.getInstance().count();
	}

}
