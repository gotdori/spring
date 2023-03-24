package com.kosa.mycompany.member;

import java.util.List;

public interface MemberDao {
	public void insert(MemberDto dto);
	public boolean isDuplicate(MemberDto dto);
	MemberDto logon(MemberDto dto);
	MemberDto findId(MemberDto dto);
	List<MemberDto> listData(MemberDto dto);
	int getTotalCnt(MemberDto dto);
}
