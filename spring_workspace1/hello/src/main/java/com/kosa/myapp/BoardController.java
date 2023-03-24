package com.kosa.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

	@RequestMapping(value="/post/add", method=RequestMethod.POST)
	public String add(int x, int y, Model model) {
		model.addAttribute("x",x);
		model.addAttribute("y",y);
		model.addAttribute("result",x+y);
		
		return "post/add";
	}
	
}
