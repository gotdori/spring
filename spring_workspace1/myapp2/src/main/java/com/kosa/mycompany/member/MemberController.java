package com.kosa.mycompany.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	@Autowired
	MemberService service;

	@RequestMapping(value = "/member/write")
	public String write() {
		return "/member/write";
	}

	@RequestMapping(value = "/member/save")
	public String save(MemberDto dto) {
		service.insert(dto);
		return "redirect:/guestbook/list";
	}

	// /member/idcheck?user_id=kboo321

	@ResponseBody // jsp 이동이 아니라 json 형태의 데이터를 출력한다.
	@RequestMapping(value = "/member/idcheck")
	public Map<String, String> isDuplication(MemberDto dto) {
		// return "페이지명" - viewResolver 가 가져가서 jsp 를 호출한다.

		Map<String, String> map = new HashMap<String, String>();

		if (service.isDuplication(dto))
			map.put("result", "fail");
		else
			map.put("result", "success");
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/member/logon_proc")
	public Map<String, String> logon_proc(MemberDto dto, HttpServletRequest req) {
		Map<String, String> map = new HashMap<String, String>();

		MemberDto resultDto = service.logon(dto);
		if (resultDto == null) // 데이터 읎음
		{
			map.put("result", "1");
			map.put("message", "해당 아이디가 존재하지 않습니다.");
			return map;
		}
		if (!resultDto.getPassword().equals(dto.getPassword())) {
			map.put("result", "1");
			map.put("message", "패스워드가 존재하지 않습니다.");
			return map;
		}
		map.put("result", "0");
		map.put("message", "로그온 되셨습니다.");

		HttpSession session = req.getSession(); // 세션 객체를 가져온다
		// 세션은 웹에 접근하는 사용자마다 하나씩 객체가 자동으로 만들어진다.
		session.setAttribute("user_id", resultDto.getUser_id());
		session.setAttribute("user_name", resultDto.getUser_name());
		session.setAttribute("email", resultDto.getEmail());

		map.put("result", "0");
		map.put("message", "로그온 되셨습니다.");

		return map;
	}
	
	@RequestMapping(value = "/member/logon")
	public String logon() {
		//logon 페이지로 이동하기
		return "member/logon";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/findid_proc")
	public Map<String, String> findId_proc(MemberDto dto){
		Map<String, String> map = new HashMap<String, String>();
		
		MemberDto resultDto = service.findId(dto);
		if (resultDto == null) {
			map.put("result", "1");
			map.put("message", "해당 정보가 존재하지 않습니다.");
			return map;
		}
		map.put("result", "0");
		map.put("message", "해당 아이디를 찾았습니다");
		map.put("user_id", resultDto.getUser_id());
		return map;
	}
	
	@RequestMapping(value="/member/findid")
	public String findid() {
		return "member/findid";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/listdata")
	public Map<String, Object> listdata(MemberDto dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("totalCnt", service.getTotalCnt(dto));
		map.put("data", service.listData(dto));
		return map;
		
	}
	@RequestMapping(value="/member/list")
	public String list(Model model, MemberDto dto) {
		model.addAttribute("totalCnt", service.getTotalCnt(dto));
		return "member/list";
	}
}




















