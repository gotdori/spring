package com.ds.damin.mall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ds.damin.common.CommonConst;
import com.ds.damin.common.Criteria;
import com.ds.damin.common.FileUploadUtil;
import com.ds.damin.common.PagerMakerDto;

@Controller
public class MallController {

	@Resource(name = "mallService")
	MallService service;

	@RequestMapping(value = "/mall/list")
	public String getList(Criteria cri, Model model) {
		
		List<MallDto> list = new ArrayList<MallDto>();
		list = service.getListPaging(cri);
		
		int total = service.getTotal();
		PagerMakerDto pdto = new PagerMakerDto(cri, total);
		model.addAttribute("pageMaker", pdto);
		model.addAttribute("mallList", list);

		return "/mall/p_list";
	}
	

	@RequestMapping(value = "/mall/view")
	public String getView(MallDto dto, Model model) {

		model.addAttribute("mallgetView", service.getView(dto));

		return "mall/p_view";
	}

	@RequestMapping(value = "/mall/write")
	public String write(Model model) {
		MallDto dto2 = new MallDto();
		model.addAttribute("MallDto", dto2);
		return "/mall/p_write";
	}

	@ResponseBody
	@RequestMapping(value = "/mall/save")
	public HashMap<String, Object> save(MallDto dto, MultipartHttpServletRequest multi) {
		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(multi.getFile("file1"));
		fileList.add(multi.getFile("file2"));
		fileList.add(multi.getFile("file3"));

		List<String> fileNameList = new ArrayList<String>();

		String path = CommonConst.UPLOD_PATH + "/p_image";
		FileUploadUtil.setFilePath(path);
		FileUploadUtil.upload(fileList, fileNameList);

		switch (fileNameList.size()) {
		case 3:
			dto.setP_image3(fileNameList.get(2));
		case 2:
			dto.setP_image2(fileNameList.get(1));
		case 1:
			dto.setP_image1(fileNameList.get(0));
		}
		service.insert(dto);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("res", "등록되었습니다.");

		return map;
	}

	@RequestMapping(value = "/mall/update")
	public String update(MallDto dto, Model model) {
		MallDto tmmpdto = service.getView(dto);
		model.addAttribute("MallDto", tmmpdto);

		return "/mall/p_write";
	}

	@ResponseBody
	@RequestMapping(value = "/mall/update_save")
	public HashMap<String, Object> update_save(MallDto dto, MultipartHttpServletRequest multi, String[] del,
			String[] old_name) {

		dto.setP_image1(old_name[0]);
		dto.setP_image2(old_name[1]);
		dto.setP_image3(old_name[2]);

		String path = CommonConst.UPLOD_PATH + "/p_image";
		FileUploadUtil.setFilePath(path);

		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(multi.getFile("file1"));
		fileList.add(multi.getFile("file2"));
		fileList.add(multi.getFile("file3"));

		List<String> fileNameList = new ArrayList<String>();
		FileUploadUtil.upload(fileList, fileNameList);


		switch (fileNameList.size()) {
		case 3:
			dto.setP_image3(fileNameList.get(2));
		case 2:
			dto.setP_image2(fileNameList.get(1));
		case 1:
			dto.setP_image1(fileNameList.get(0));
		}
		service.update(dto);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("res", "수정완료");
		
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/mall/delete")
	public HashMap<String, Object> delete(MallDto dto) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			service.delete(dto);

			map.put("result", "ok");
		} catch (Exception e) {
			map.put("result", "no");
			e.printStackTrace();
		}
		return map;
	}
	
	
//	@RequestMapping(value = "/mall/HL")
//	public String H_L_Price(Criteria cri, Model model) {
//		List<MallDto> list = new ArrayList<MallDto>();
//		list = service.H_L_getList(cri);
//		int total = service.getTotal();
//		PagerMakerDto pdto = new PagerMakerDto(cri, total);
//		
//		model.addAttribute("pageMaker", pdto);
//		model.addAttribute("mallList", list);
//		return "/mall/p_list";
//	}
	
//	@RequestMapping(value = "/mall/LH")
//	public String L_H_Price(Criteria cri, Model model) {
//		List<MallDto> list = new ArrayList<MallDto>();
//		list = service.L_H_getList(cri);
//		int total = service.getTotal();
//		PagerMakerDto pdto = new PagerMakerDto(cri, total);
//		
//		model.addAttribute("pageMaker", pdto);
//		model.addAttribute("mallList", list);
//		return "/mall/p_list";
//	}
}
