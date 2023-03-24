package com.ds.damin.common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	static String filePath = "";

	private FileUploadUtil() {
	}

	public static String getFilePath() {
		return filePath;
	}

	public static void setFilePath(String filePath) {
		FileUploadUtil.filePath = filePath;
	}

	public static void upload(List<MultipartFile> fileList, List<String> fileNameList) {
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdir();
		}
		if(fileList!=null && fileList.size()>0) {
			for (MultipartFile mfile : fileList) {
				String orifilename = mfile.getOriginalFilename();
//				System.out.println("filename : "+orifilename);
				if(orifilename==null || orifilename.equals("")) {
					fileNameList.add("");
					continue;
				}
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
		String newFilename = "";
		int pos = orifilename.lastIndexOf(".");
		String ext = "";
		String filename = "";
		if (pos != -1) {
			filename = orifilename.substring(0, pos);
			ext = orifilename.substring(pos + 1);
		} else {
			filename = orifilename;
			ext = "";
		}
//		System.out.print("파일이름 : " + filename + "\r\n");
//		System.out.print("확장자 : " + ext + "\r\n");
		newFilename = filename + "." + ext;
		File newFile = new File(filePath + "/" + newFilename);
		int i = 1;
		while (newFile.exists()) {
			newFilename = filename + "(" + i + ")" + "." + ext;
			i++;
			newFile = new File(filePath + "/" + newFilename);
		}
//		System.out.println(newFilename);
		return newFilename;
	}
}
