package com.kosa.myapp3.member;

public interface MemberService {
	public void Member_insert(MemberDto dto);
	public boolean Member_IdCheck(MemberDto dto);
	MemberDto Member_login(MemberDto dto);
}
