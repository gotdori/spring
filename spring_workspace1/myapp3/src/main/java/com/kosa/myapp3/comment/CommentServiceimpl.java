package com.kosa.myapp3.comment;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceimpl implements CommentService{

	@Resource(name="commentDao")
	CommentDao dao;
	
	@Override
	public List<CommentDto> Comment_getList(CommentDto dto) {
		return dao.Comment_getList(dto);
	}

	@Override
	public void Comment_insert(CommentDto dto) {
		dao.Comment_insert(dto);
		
	}

	@Override
	public void Comment_delete(CommentDto dto) {
		dao.Comment_delete(dto);
	}
}
