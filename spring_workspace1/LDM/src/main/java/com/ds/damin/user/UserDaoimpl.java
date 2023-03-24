package com.ds.damin.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public class UserDaoimpl implements UserDao{
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<UserDto> getList(UserDto dto) {
		return sm.selectList("User_getList", dto);
	}

	@Override
	public UserDto getView(UserDto dto) {
		return sm.selectOne("User_getView", dto);
	}
	
	@Override
	public void insert(UserDto dto) {
		sm.insert("User_insert", dto);
	}

	@Override
	public void update(UserDto dto) {
		sm.update("User_update", dto);
	}

	@Override
	public void delete(UserDto dto) {
		sm.update("User_delete", dto);
	}

	@Override
	public int idcheck(UserDto dto) {
		return sm.selectOne("User_IdCheck", dto);
	}

	@Override
	public UserDto login(UserDto dto) {
		return sm.selectOne("User_login", dto);
	}

}
