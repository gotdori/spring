package com.kosa.myapp1.인터페이스;

import java.util.List;
//인터페이스는 상수하고 함수 header 부분만, 객체 만들게 아님
public interface IBoardDao {
	List<BoardDto> getList();
	
}
