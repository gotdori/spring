package com.kosa.mycompany.member;

import java.util.List;

public interface MemberService {
	void insert(MemberDto dto);
	boolean isDuplication(MemberDto dto);
	MemberDto logon(MemberDto dto);
	MemberDto findId(MemberDto dto);
	List<MemberDto> listData(MemberDto dto);
	int getTotalCnt(MemberDto dto);
}
