package com.kosa.mycompany.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceimpl implements TestService{

	@Resource(name="testDao1")
	TestDao1 testDao1;
	
	@Resource(name="testDao2")
	TestDao2 testDao2;
	
	@Resource(name="testDao3")
	TestDao3 testDao3;
	
	@Override
	public void insertData(TestDto dto) {

		testDao1.insertData(dto);
		testDao2.insertData(dto);
		dto.setTest("과연");
		testDao3.insertData(dto);
	}


	
}
