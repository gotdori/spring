package com.kosa.mycompany.fileupload;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kosa.mycompany.common.FileUploadUtil;
@Controller
public class FileController {
	
	@RequestMapping(value="/fileupload") //jsp로 이동
	public String fileupload() {
		return "/fileupload/fileupload"; 
	}
	
	@RequestMapping(value="/fileupload/save") //파일 업로드 할 때
	public String fileuploadsave(MultipartHttpServletRequest multi) {
		
		//MultipartHttpServletRequest 객체의 getFile 함수를 호출한다.
		//이 함수가 업로드 된 파일의 정보를 갖고 있다. input type="file" 태그의  name 속성값을 가져온다.
		MultipartFile file = multi.getFile("file1");
		String path="C:\\webprograming\\spring_workspace1\\myapp2\\src\\main\\webapp\\upload";
//		File dir = new File(path);
//		if(!dir.exists())	//디렉토리가 존재하지 않으면
//			dir.mkdirs(); 	//디렉토리를 생성한다.
//		
//		try {
//			//임시 서버에 파일은 이미 올라와 있다. 이 파일을 내가 지정한 위치로 옮긴다.
//			//스프링부트부터 다른 방식 사용
//			//새로운 파일명 -- 기존의 파일명 가져와서 반영해서 만들지 아니면 새로 만들지
//			file.transferTo(new File(path+"//a.jpg"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		List<MultipartFile> multiList = new ArrayList<MultipartFile>();
		multiList.add(multi.getFile("file1"));
		
		List<String> fileNameList = new ArrayList<String>();
		fileNameList.add("filename1");
		
		FileUploadUtil.setFilePath(path);
		FileUploadUtil.upload(multiList, fileNameList);
		return "redirect:/";
	}
}
