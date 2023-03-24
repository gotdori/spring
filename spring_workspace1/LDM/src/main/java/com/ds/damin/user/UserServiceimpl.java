package com.ds.damin.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceimpl implements UserService{
	
	@Resource(name="UserDao")
	UserDao dao;

	@Override
	public List<UserDto> getList(UserDto dto) {
		return dao.getList(dto);
	}
	
	@Override
	public UserDto getView(UserDto dto) {
		return dao.getView(dto);
	}

	@Override
	public void insert(UserDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(UserDto dto) {
		dao.update(dto);
	}

	@Override
	public void delete(UserDto dto) {
		dao.delete(dto);
	}

	@Override
	public boolean idcheck(UserDto dto) {
		return dao.idcheck(dto)!=0; //중복되면 true 사용가능하면 false 리턴
	}

	@Override
	public UserDto login(UserDto dto) {
		return dao.login(dto);
	}

}
