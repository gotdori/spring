package com.kosa.mycompany.guestbook;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("guestbookDao")
public class GuestbookDaoimpl implements GuestbookDao{
	//org.mybatis.spring.SqlSessionTemplate
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<GuestbookDto> getList(GuestbookDto dto) {
		
		//Guestbook_getList : mapper파일(Guestbook.xml)에 있는 쿼리 id 값을 전달한다.
		//두번째 파라미터인 dto는 parameterType에 전달한다.
		//selectList함수는 xml파일에 쿼리를 불러와서 실행 시킨 후 결과를 resultType에서 지정한 객체를 만들고 값을 넣은 후 ArrayList 객체를 만들어 dto객체 추가 후 반환한다.
		return sm.selectList("Guestbook_getList", dto);
	}

	@Override
	public int getTotaCnt(GuestbookDto dto) {
		return sm.selectOne("GuestBook_getTotalCnt", dto);
	}

	@Override
	public GuestbookDto getView(GuestbookDto dto) {
		return sm.selectOne("GuestBook_getView", dto);
	}

	@Override
	public void insert(GuestbookDto dto) {
		sm.insert("GuestBook_insert",dto);
	}

	@Override
	public void update(GuestbookDto dto) {
		sm.update("Guestbook_update",dto);
	}

	@Override
	public void delete(GuestbookDto dto) {
		sm.delete("Guestbook_delete",dto);
	}

	
}
