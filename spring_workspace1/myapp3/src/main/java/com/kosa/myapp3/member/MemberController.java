package com.kosa.myapp3.member;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	
	@Resource(name="memberService")
	MemberService service;
	
	@ResponseBody
	@RequestMapping(value="/member/save")
	Map<String, Object> member_save(MemberDto dto){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("msg", "회원가입을 축하드립니다.");
		
		return map;
		
	}
	
	@RequestMapping(value="/member/write")
	String member_write(MemberDto dto) {
		return "member/member_write";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/idcheck")
	Map<String, Object> member_idcheck(MemberDto dto){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.Member_IdCheck(dto));
		return map;
	}
	
	@RequestMapping(value="/member/login")
	String member_login() {
		return "/member/member_login";
	}
	
	//세션 객체는 사용자가 브라우저를 통해서 서버로 접근하면 사용자마다 이미 만들어져 있다.
	@ResponseBody
	@RequestMapping(value="/member/loginproc")
	Map<String, Object> member_loginproc(MemberDto dto,  HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		
		//시스템에서 서버 접근 요청이 있을 때(서버접근자마다) 하나씩 개체가 만들어 진다.
		HttpSession session = req.getSession();  //request, session, map
		
		MemberDto resultDto = service.Member_login(dto);
		
		if(resultDto == null) {
			map.put("result", "fail");
			map.put("msg", "해당 아이디가 존재하지 않습니다.");
			return map;
		}
		if(!resultDto.getPassword().equals(dto.getPassword())) {
			map.put("result", "fail");
			map.put("msg", "패스워드가 일치하지 않습니다.");
			return map;
		}
		session.setAttribute("user_id", resultDto.getUser_id());
		session.setAttribute("user_name", resultDto.getUser_name());
		
		map.put("result", "success");
		map.put("msg", "로그인 되었슈");
		
		return map;
		
		//코드 작성 시 에러 상황을 위로 올리고 마지막에  결과를 넣으면 코드가 깔끔해짐(최대한 else 안넣기) 
	}
	@ResponseBody
	@RequestMapping("/member/logout") //제이슨으로 하면 메시지도 뿌릴 수 있땨
	Map<String, Object> member_logout(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();	
		HttpSession session = req.getSession(false); //여기 안에 펄스를 넣으면 알아서 세션 값 있는지 확인해줌
		session.invalidate(); // 세션내용 삭제
		map.put("result", "로그아웃 됏쓔");
		
		return map;
	}
}
