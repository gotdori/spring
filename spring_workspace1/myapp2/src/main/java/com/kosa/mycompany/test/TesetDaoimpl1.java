package com.kosa.mycompany.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDao1")
public class TesetDaoimpl1 implements TestDao1{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insertData(TestDto dto) {
		sm.insert("Test1_insert", dto);
	}

}
