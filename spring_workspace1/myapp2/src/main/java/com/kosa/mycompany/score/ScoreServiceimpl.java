package com.kosa.mycompany.score;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("ScoreService")
public class ScoreServiceimpl implements ScoreService{

	@Resource(name="ScoreDao")
	ScoreDao dao;
	@Override
	public List<ScoreDto> getList(ScoreDto dto) {
		return dao.getList(dto);
	}
	@Override
	public ScoreDto getView(ScoreDto dto) {
		return dao.getView(dto);
	}
	
	
}
