package com.kosa.myapp3.board;

import java.util.List;

public interface BoardService {
	int Board_getTotalCnt(BoardDto dto);
	List<BoardDto> Board_getList(BoardDto dto);
	BoardDto Board_getView(BoardDto dto);
	void Board_insert(BoardDto dto);
	void Board_update(BoardDto dto);
	void Board_delete(BoardDto dto);
	void Board_hit(BoardDto dto);
	void Board_reply(BoardDto dto);
	void Board_update_level(BoardDto dto);
	BoardDto Board_findmommy(BoardDto dto);
	void Board_childcountplus(BoardDto dto);
	void Board_childcountminus(BoardDto dto);
	
}
