package com.kosa.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	//url:http://127.0.0.1:9000/test
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		System.out.println("test");
		return "test";
	}
	
	//url:http://127.0.0.1:9000/myapp/test2?user_id=test&password=1234
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public String test2(String user_id, String password, Model model, TestDto dto) {
		//Model request객체 댇신에 jsp로 값 전달할 목적으로 사용한다.
		model.addAttribute("user_id", user_id);
		model.addAttribute("password", password);
		
		System.out.println("user_id"+user_id);
		System.out.println("password"+password);
		
		
		System.out.println("user_id"+dto.getUser_id());
		System.out.println("password"+dto.getPassword());
		return "test2";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(HttpServletRequest req, Model model){
		int x=Integer.parseInt(req.getParameter("x"));
		int y=Integer.parseInt(req.getParameter("y"));
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result",x+y);
		
		return "add";
	}
	
	@RequestMapping(value="/sub/{x}/{y}", method=RequestMethod.GET)
	public String sub(Model model, @PathVariable("x")int x, @PathVariable("y")int y){
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result",x-y);
		
		return "sub";
	}
	
}
