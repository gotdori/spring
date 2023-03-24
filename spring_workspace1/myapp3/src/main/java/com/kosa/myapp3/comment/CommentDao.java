package com.kosa.myapp3.comment;

import java.util.List;

public interface CommentDao {
	List<CommentDto> Comment_getList(CommentDto dto);
	void Comment_insert(CommentDto dto);
	void Comment_delete(CommentDto dto);
}
