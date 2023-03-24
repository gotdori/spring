package com.kosa.myapp3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.myapp3.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceimpl implements MemberService{

	@Autowired
	MemberMapper memberDao;
	
	@Override
	public void Member_insert(MemberDto dto) {
		memberDao.Member_insert(dto);
	}
	
	@Override
	public boolean Member_IdCheck(MemberDto dto) {
		return memberDao.Member_IdCheck(dto) != 0;
	}
	
	@Override
	public MemberDto Member_login(MemberDto dto) {
		return memberDao.Member_login(dto);
	}
}
