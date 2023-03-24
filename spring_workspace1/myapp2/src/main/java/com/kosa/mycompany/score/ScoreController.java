package com.kosa.mycompany.score;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ScoreController {
	@Resource(name="ScoreService")
	ScoreService service;

	@RequestMapping(value="/score/list")
	public String getList(ScoreDto dto, Model model) {
		System.out.println("asdasd");
		List<ScoreDto> list = service.getList(dto);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		model.addAttribute("list", list);
		return "/score/list";
	}
	
	@RequestMapping(value="/score/view")
	public String getView(ScoreDto dto, Model model) {
		model.addAttribute("view", service.getView(dto));
		System.out.println(dto);
		return "/score/view";
		
	}
}
