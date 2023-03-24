package com.kosa.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShapeController {
	
	@RequestMapping(value="/circle/{x}", method=RequestMethod.GET)
	public String circle(Model model, @PathVariable("x")int x) {
		model.addAttribute("x",x);
		model.addAttribute("result",x*x*3.14);
		return "circle";
	}
	

}
