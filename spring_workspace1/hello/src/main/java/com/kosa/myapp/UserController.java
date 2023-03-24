package com.kosa.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value="/post/userinfo", method=RequestMethod.POST)
	public String userInfo(UserDto dto, Model model) {
//		model.addAttribute("user_id", dto.getUser_id());
//		model.addAttribute("user_name", dto.getUser_name());
//		model.addAttribute("phone", dto.getPhone());
//		model.addAttribute("email", dto.getEmail());
//		model.addAttribute("address", dto.getAddress());
		
		model.addAttribute("dto", dto);
		
		return "post/userinfo";
	}

}
