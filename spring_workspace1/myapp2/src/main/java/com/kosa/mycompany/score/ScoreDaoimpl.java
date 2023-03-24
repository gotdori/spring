package com.kosa.mycompany.score;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosa.mycompany.guestbook.GuestbookDto;

@Repository("ScoreDao")
public class ScoreDaoimpl implements ScoreDao{

	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<ScoreDto> getList(ScoreDto dto) {
		return sm.selectList("Score_getList", dto);
	}

	@Override
	public ScoreDto getView(ScoreDto dto) {
		return sm.selectOne("Score_getView", dto);
	}
}
