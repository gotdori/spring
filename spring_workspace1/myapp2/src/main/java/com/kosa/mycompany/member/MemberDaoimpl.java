package com.kosa.mycompany.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoimpl implements MemberDao{
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public void insert(MemberDto dto) {
		sm.insert("Member_insert", dto);
	}

	@Override
	public boolean isDuplicate(MemberDto dto) {
		int result=sm.selectOne("Member_idcheck",dto);
		if(result==0) 
		return false;
		else
		return true;
		}

	@Override
	public MemberDto logon(MemberDto dto) {
		return sm.selectOne("Member_login", dto);
	}

	@Override
	public MemberDto findId(MemberDto dto) {
		return sm.selectOne("member_findId", dto);
	}

	@Override
	public List<MemberDto> listData(MemberDto dto) {
		return sm.selectList("Member_listData", dto);
	}

	@Override
	public int getTotalCnt(MemberDto dto) {
		return sm.selectOne("Member_totalCnt", dto);
	}


	}



	
