package com.kosa.mycompany;

import java.util.List;

public interface HomeService {
	List<HomeDto> getList(HomeDto dto);
	void insert(HomeDto dto);
}
