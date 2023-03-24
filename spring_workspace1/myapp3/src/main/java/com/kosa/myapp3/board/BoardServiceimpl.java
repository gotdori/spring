package com.kosa.myapp3.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceimpl implements BoardService {

	@Resource(name = "boardDao")
	BoardDao dao;

	@Override
	public int Board_getTotalCnt(BoardDto dto) {
		return dao.Board_getTotalCnt(dto);
	}

	@Override
	public List<BoardDto> Board_getList(BoardDto dto) {
		return dao.Board_getList(dto);
	}

	@Override
	public void Board_insert(BoardDto dto) {
		dao.Board_insert(dto);
	}

	@Override
	public void Board_update(BoardDto dto) {
		dao.Board_update(dto);
	}

	@Override
	public void Board_delete(BoardDto dto) {
		Board_childcountminus(dto);
		dao.Board_delete(dto);

	}

	@Override
	public BoardDto Board_getView(BoardDto dto) {
		return dao.Board_getView(dto);
	}

	@Override
	public void Board_hit(BoardDto dto) {
		dao.Board_hit(dto);
	}

	@Override
	public void Board_reply(BoardDto dto) {
		// dto - seq : 부모글의 seq이다.
		// 부모글의 정보를 가져와야 한다.
		BoardDto HlevelDto = dao.Board_getView(dto);
		Board_childcountplus(HlevelDto);

		dto.setGroup_id(HlevelDto.getGroup_id());
		dto.setDepth(HlevelDto.getDepth() + 1);
		dto.setG_level(HlevelDto.getG_level() + 1);
		dto.setChildcount(HlevelDto.getChildcount());
		System.out.println("아들갯수 :"+dto.getChildcount());
		// 부모글 기반으로 update level
		dao.Board_update_level(HlevelDto);
		dao.Board_reply(dto);
	}

	@Override
	public BoardDto Board_findmommy(BoardDto dto) {
		return dao.Board_findmommy(dto);
	}

	@Override
	public void Board_childcountplus(BoardDto dto) {
		BoardDto parentDto = dto;
		while (parentDto != null) {
			dao.Board_childcountplus(parentDto);
			parentDto = dao.Board_findmommy(parentDto);
		}
	}

	@Override
	public void Board_childcountminus(BoardDto dto) {
		BoardDto parentDto = Board_findmommy(dto);
		while (parentDto != null) {
			dao.Board_childcountminus(parentDto);
			parentDto = Board_findmommy(parentDto);
		}
	}

	@Override
	public void Board_update_level(BoardDto dto) {
		dao.Board_update_level(dto);
	}

}
