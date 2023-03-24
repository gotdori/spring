package com.kosa.myapp3.mapper;

import com.kosa.myapp3.member.MemberDto;

public interface MemberMapper {
	public void Member_insert(MemberDto dto);
	public int Member_IdCheck(MemberDto dto);
	MemberDto Member_login(MemberDto dto);
}
