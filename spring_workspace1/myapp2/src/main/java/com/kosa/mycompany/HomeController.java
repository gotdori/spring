package com.kosa.mycompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kosa.mycompany.common.FileUploadUtil;
import com.kosa.mycompany.gallery.GalleryDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource(name="homeService")
	HomeService homeService;
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@ResponseBody
	@RequestMapping(value = "/home/list")
	public Map<String, Object> home_list(Model model, HomeDto dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", homeService.getList(dto));

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/home/save")
	public Map<String, String> home_save(MultipartHttpServletRequest multi, HomeDto dto) {
		Map<String, String> resultMap = new HashMap<String, String>();
		
		System.out.println(dto.getName());
		System.out.println(dto.getImage());
		
		MultipartFile file = multi.getFile("get_file");
		List<MultipartFile> fileList = new ArrayList<MultipartFile>();
		fileList.add(file);
		List<String> fileNameList = new ArrayList<String>();
		
		String path = "C:\\webprograming\\spring_workspace1\\myapp2\\src\\main\\webapp\\upload";
		FileUploadUtil.setFilePath(path);
		
		FileUploadUtil.upload(fileList, fileNameList);
		dto.setImage(fileNameList.get(0));
		
		System.out.println(dto.getImage());
		
		homeService.insert(dto);
		
		resultMap.put("result", "0");
		resultMap.put("message", "글이 등록됐슈");
		return resultMap;
	}
	
	@RequestMapping(value="/home/write")
	public String home_write() {
		return "home/home_write";
	}
}
