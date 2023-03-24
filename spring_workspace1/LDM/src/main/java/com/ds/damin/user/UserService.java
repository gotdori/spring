package com.ds.damin.user;

import java.util.List;

public interface UserService {
	List<UserDto> getList(UserDto dto);
	UserDto getView(UserDto dto);
	void insert(UserDto dto);
	void update(UserDto dto);
	void delete(UserDto dto);
	boolean idcheck(UserDto dto);
	UserDto login(UserDto dto);
}
