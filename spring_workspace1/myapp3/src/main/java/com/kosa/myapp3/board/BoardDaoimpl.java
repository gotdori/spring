package com.kosa.myapp3.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDaoimpl implements BoardDao{
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public int Board_getTotalCnt(BoardDto dto) {
		return sm.selectOne("Board_getTotalCnt", dto);
	}

	@Override
	public List<BoardDto> Board_getList(BoardDto dto) {
		return sm.selectList("Board_getList", dto);
	}

	@Override
	public void Board_insert(BoardDto dto) {
		sm.insert("Board_insert", dto);
	}

	@Override
	public void Board_update(BoardDto dto) {
		sm.update("Board_update", dto);
	}

	@Override
	public void Board_delete(BoardDto dto) {
		//dto - group_id, depth, g_level
		System.out.println("그룹 아이디 : " + dto.getGroup_id());
		System.out.println("깊이 : " + dto.getDepth());
		System.out.println("레벨 : " + dto.getG_level());
			sm.update("Board_delete", dto);
	}

	@Override
	public BoardDto Board_getView(BoardDto dto) {
		return sm.selectOne("Board_getView", dto);
	}

	@Override
	public void Board_hit(BoardDto dto) {
		sm.update("Board_hit", dto);
	}

	@Override
	public void Board_reply(BoardDto dto) {
		sm.insert("Board_reply", dto);
	}

	@Override
	public BoardDto Board_findmommy(BoardDto dto) {
		return sm.selectOne("Board_findmommy", dto);
	}

	@Override
	public void Board_childcountplus(BoardDto dto) {
		sm.update("Board_childcountplus", dto);
	}

	@Override
	public void Board_update_level(BoardDto dto) {
		sm.update("Board_reply_level_update", dto);
		
	}

	@Override
	public void Board_childcountminus(BoardDto dto) {
		sm.update("Board_childcountminus", dto);
		
	}
}
