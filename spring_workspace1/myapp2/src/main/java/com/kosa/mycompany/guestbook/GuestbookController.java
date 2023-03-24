package com.kosa.mycompany.guestbook;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosa.mycompany.score.ScoreDto;

@Controller
public class GuestbookController {
	@Resource(name = "guestbookService")
	GuestbookService service;

	@RequestMapping(value = "/guestbook/list")
	public String getList(GuestbookDto dto, Model model) {

		List<GuestbookDto> list = service.getList(dto);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTitle());
		}

		model.addAttribute("list", list);
		model.addAttribute("totalCnt", service.getTotalCnt(dto));
		return "guestbook/list";
	}

	@RequestMapping(value = "/guestbook/view")
	public String getView(GuestbookDto dto, Model model) {
		GuestbookDto resultDto = service.getView(dto);

		model.addAttribute("view", resultDto);
		return "guestbook/view";
	}

	@RequestMapping(value = "/guestbook/write")
	public String write(Model model) {
		return "guestbook/write";
	}

	@RequestMapping(value = "/guestbook/save")
	public String save(GuestbookDto dto, Model model) {
		service.insert(dto);
		//서비스를 이용해 DB에 등록한다.
		return "redirect:/guestbook/list";
		//redirect 하는 이유 : request 객체의 내용을 지우고 직접 jsp로 이동하는게 아니라 guestbook/list url로 이동시 redirect를 해야한다.
		//등록을 하고나면 getlist() 함수를 호출해야 하는데 직접 호출못함. 중간에 프레임 워크가 하는 일이 많다.
		//함수를 직접 호출 못하고 url로 접근해야 한다.
		//redirect : 호출할 url을 기술한다.
	}

}
