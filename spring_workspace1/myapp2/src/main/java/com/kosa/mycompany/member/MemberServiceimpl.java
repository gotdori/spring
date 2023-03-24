package com.kosa.mycompany.member;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceimpl implements MemberService{
	
	@Autowired
	MemberDao dao;
	
	@Override
	public void insert(MemberDto dto) {
		dao.insert(dto);
	}
	@Override
	public boolean isDuplication(MemberDto dto) {
		return dao.isDuplicate(dto);
	}
	@Override
	public MemberDto logon(MemberDto dto) {
		return dao.logon(dto);
	}
	@Override
	public MemberDto findId(MemberDto dto) {
		return dao.findId(dto);
	}
	@Override
	public List<MemberDto> listData(MemberDto dto) {
		return dao.listData(dto);
	}
	@Override
	public int getTotalCnt(MemberDto dto) {
		return dao.getTotalCnt(dto);
	}
}
