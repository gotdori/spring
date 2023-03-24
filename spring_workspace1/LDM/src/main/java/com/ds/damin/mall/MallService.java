package com.ds.damin.mall;

import java.util.List;

import com.ds.damin.common.Criteria;

public interface MallService {
	List<MallDto> getList(MallDto dto);
	MallDto getView(MallDto dto);
	void insert(MallDto dto);
	void update(MallDto dto);
	void delete(MallDto dto);
	List<MallDto> getListPaging(Criteria cri);
	int getTotal();
}
