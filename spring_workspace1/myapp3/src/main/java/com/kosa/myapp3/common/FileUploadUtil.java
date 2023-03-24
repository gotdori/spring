package com.kosa.myapp3.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {
	static String filePath=""; //물리적 경로가 와야함
	//생성자를 private으로 만들면 개체생성 불가
	private FileUploadUtil() {}

	public static String getFilePath() {
		return filePath;
	}
	
	public static void setFilePath(String filePath) {
		FileUploadUtil.filePath = filePath;
	}
	
	//컨트롤러에서 MultipartFile객체리스트를 전달하면 파일 저장 후 파일의 이름 목록을 전달한다.
	//파일의 이름 목록을 전달한다.
	//파일명이 충돌될 때 충돌을 방지하기 위한 수단. a.jpg, a(1).jpg, a(2).jpg
	//또는 202302021145001nnn.jsp
	public static void upload(List<MultipartFile> fileList, List<String> fileNameList) {
		File file = new File(filePath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//첨부파일이 있을 때
		if(fileList!=null && fileList.size()>0) {
			for (MultipartFile mfile : fileList) {
				// 1. 본래 파일명을 가져온다.
				String orifilename = mfile.getOriginalFilename();
				System.out.println("filename : "+orifilename);
				if(orifilename==null || orifilename.equals("")) {
					fileNameList.add("");
					continue;
				}
				//파일명이 충돌 안나게 바꾼다
				String newFileName = getFileName(orifilename);
				try {
					mfile.transferTo(new File(filePath+"/"+newFileName));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				fileNameList.add(newFileName);
			}
		}
	}
	
	public static String getFileName(String orifilename) {
		String newFilename="";
		//1. 파일명과 확장자를 구분한다.
		//오른쪽에서 .(점)이 있는 위치값을 찾는다.
		int pos = orifilename.lastIndexOf("."); //오른쪽 끝에서부터 찾는다.
		String ext="";
		String filename="";
		if(pos!=-1) {
			filename=orifilename.substring(0, pos); //파일명만 추출
			ext = orifilename.substring(pos+1); //확장자만 추출하기
		}
		else { //확장자가 없는 파일일 경우
			filename = orifilename;
			ext="";
		}
		System.out.print("파일이름 : "+filename+"\r\n");
		System.out.print("확장자 : "+ext+"\r\n");
		newFilename = filename +"." + ext;
		File newFile = new File(filePath +"/" +newFilename);
		int i=1;
		while(newFile.exists()) {//파일이 있다면
			//새로운 파일명을 만든다.
			newFilename = filename + "("+i+")"+"."+ext;
			i++;
			newFile = new File(filePath +"/"+newFilename); //다시 확인
		}
		System.out.println(newFilename);
		return newFilename;
	}
	
}
