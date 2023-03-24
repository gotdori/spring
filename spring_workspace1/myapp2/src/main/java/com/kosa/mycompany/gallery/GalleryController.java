package com.kosa.mycompany.gallery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kosa.mycompany.common.FileUploadUtil;

@Controller
public class GalleryController {

	@Autowired
	GalleryService service;

	@Resource(name = "galleryService")
	GalleryService galleryService;

	@RequestMapping(value = "/gallery/write")
	public String gallery_write() {
		return "gallery/write";
	}

	@ResponseBody
	@RequestMapping(value = "/gallery/save")
	public Map<String, String> gallery_save(MultipartHttpServletRequest multi, GalleryDto dto) {
		Map<String, String> resultMap = new HashMap<String, String>();

		// 주의사항 : 파일 받을 때 변수명하고 태그이름하고 같으면 문제가 발생한다.
		// 파일을 받아서 별도 처리해주고 파일명을 변수에 할당하면 된다.
		System.out.println(dto.getTitle());
		System.out.println(dto.getWriter());
		System.out.println(dto.getContents());
//		System.out.println(dto.getImage());

		MultipartFile file = multi.getFile("file1");
		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(file);

		List<String> fileNameList = new ArrayList<String>();
//		fileNameList.add("");

		String path = "C:\\webprograming\\spring_workspace1\\myapp2\\src\\main\\webapp\\upload";
		FileUploadUtil.setFilePath(path); // 경로설정

		FileUploadUtil.upload(fileList, fileNameList);
		dto.setImage(fileNameList.get(0));

		System.out.println(dto.getImage());

		galleryService.insert(dto);

		resultMap.put("result", "0");
		resultMap.put("message", "글이 등록되었습니다.");
		return resultMap;
	}

	@ResponseBody
	@RequestMapping(value = "/gallery/listdata")
	public Map<String, Object> listdata(GalleryDto dto) {
		
		dto.setPgSize(12);
		System.out.println(dto.getSearchKey());
		System.out.println(dto.getSearchKeyword());
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("data", service.getList(dto));
		return map;
	}
	
	@RequestMapping(value = "/gallery/gallery_list")
	public String list(Model model, GalleryDto dto) {
		
		System.out.println(dto.getSearchKey());
		System.out.println(dto.getSearchKeyword());
		
		model.addAttribute("totalCnt", service.getTotalCnt(dto));
		return "gallery/gallery_list";
	}

}
