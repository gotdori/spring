package com.kosa.mycompany.guestbook;

import java.util.List;

public interface GuestbookDao {
	List<GuestbookDto> getList(GuestbookDto dto);
	int getTotaCnt(GuestbookDto dto);
	
	GuestbookDto getView(GuestbookDto dto);
	
	void insert(GuestbookDto dto);
	void update(GuestbookDto dto);
	void delete(GuestbookDto dto);
	
}
