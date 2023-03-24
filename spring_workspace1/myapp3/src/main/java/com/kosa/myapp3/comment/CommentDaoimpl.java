package com.kosa.myapp3.comment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commentDao")
public class CommentDaoimpl implements CommentDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<CommentDto> Comment_getList(CommentDto dto) {
		return sm.selectList("Comment_getList", dto);
	}

	@Override
	public void Comment_insert(CommentDto dto) {
		sm.selectOne("Comment_insert", dto);
		
	}

	@Override
	public void Comment_delete(CommentDto dto) {
		sm.update("Comment_delete", dto);
	}
}
