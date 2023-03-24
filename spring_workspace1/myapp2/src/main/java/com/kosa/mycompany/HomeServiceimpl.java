package com.kosa.mycompany;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("homeService")
public class HomeServiceimpl implements HomeService{

	@Resource
	HomeDao dao;
	
	@Override
	public List<HomeDto> getList(HomeDto dto) {
		return dao.getList(dto);
	}

	@Override
	public void insert(HomeDto dto) {
		dao.insert(dto);
	}

}
