package com.ds.damin.user;

import java.util.List;

public interface UserDao {
	List<UserDto> getList(UserDto dto);
	UserDto getView(UserDto dto);
	void insert(UserDto dto);
	void update(UserDto dto);
	void delete(UserDto dto);
	int idcheck(UserDto dto);
	UserDto login(UserDto dto);
}
