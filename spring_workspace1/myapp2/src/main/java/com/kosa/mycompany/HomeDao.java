package com.kosa.mycompany;

import java.util.List;

public interface HomeDao {
	List<HomeDto> getList(HomeDto dto);
	void insert(HomeDto dto);
}
