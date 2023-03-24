package com.kosa.mycompany;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("homeDao")
public class HomeDaoimpl implements HomeDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<HomeDto> getList(HomeDto dto) {
		return sm.selectList("Home_getList", dto);
	}

	@Override
	public void insert(HomeDto dto) {
		sm.insert("Home_insert", dto);
	}
}
