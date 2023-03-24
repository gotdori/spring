package com.kosa.mycompany.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDao3")
public class TesetDaoimpl3 implements TestDao3{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insertData(TestDto dto) {
		sm.insert("Test3_insert", dto);
	}

}
