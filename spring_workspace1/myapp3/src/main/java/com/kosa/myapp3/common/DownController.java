package com.kosa.myapp3.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownController {

	@RequestMapping(value="/down")
	public void download(HttpServletRequest req, HttpServletResponse res, String path, String filename) {
		// path : 모든 파일을 같은 폴더에 업로드 하면 관리가 어렵다.
		//  /upload/board, /upload/gallery, /upload/qna
		// 이런식으로 나누어서 업로드
		
		// filename : 다운로드 할 파일명
		
		//서블릿 3.0 이상부터 가상폴더의 실제 물리적 구조를 알려주는 함수가 생겼다
		//이전부터 있긴 했지만 클래스와 함수 이름이 달라짐
		
		//현장에서는 이렇게 써도 됨
//		ServletContext ctx = req.getServletContext();
//		String fullpath = ctx.getRealPath("/upload/"+path);
		
		String fullpath=CommonConst.UPLOAD_PATH+"/"+path;
		System.out.println(fullpath);
		System.out.println(filename);
		
		//서버에 있는 파일을 읽어서 클라이언트로 전송해야 한다.
		InputStream in = null; //서버(파일을 읽어서)
		OutputStream out = null; //클라이언트에게 전송한다.
		File file = null;
		
		//파일은 두 종류가 있다
		//이진파일
		try {
			file = new File(fullpath, filename); //파일을 찾아서
			in = new FileInputStream(file); 	//읽을 준비중이다
		} catch (FileNotFoundException e) {		//파일이 존재하지 않거나 그 밖의 오류로 전송불가면
			e.printStackTrace();
			return;
		} 
		try {
			String client = req.getHeader("User-Agent");
			if (client.indexOf("MSIE")!=-1) {
				filename = new String(filename.getBytes("KSC5601"),"ISO8859_1");
			}
			filename = new String(filename.getBytes("KSC5601"),"iso-8859-1");
			//한글처리
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		//보낼 준비
		res.reset(); //혹시 서버에 클라이언트로 보낼 정보가 남아있을 경우 비우자
		res.setContentType("application.octet-stream");
		//2진형태로 파일을 보내겠다는 사실을 클라이언트에 알린다.
		//attachment; filename="test.txt"
		res.setHeader("Content-Disposition", "attachment; filename=\""+filename+"");
		res.setHeader("Content-type", "application/octet-stream");
		res.setHeader("Content-length", file.length()+"");
		
		try {
			out = res.getOutputStream(); //파일을 보내기 위한 통로 개설
			//파일을 byte 단위로 읽어야 함
			//파일이 커서 한번에 메모리 확보가 안될 경우에 잘라서 읽어 보내야 한다.
			//현재는 파일 하나를 저장할 byte 배열을 만들었음
			byte b[] = new byte[(int)file.length()];
			int leng=0;
			//in.read(b) : 주어진 배열 크기만큼 데이터를 읽어온다.
			//반환값은 실제로 읽은 데이터 크기이다.
			while((leng=in.read(b))>0) { //>0 읽은 데이터가 있다면
				out.write(b, 0, leng); //클라이언트로 전송하라
			}
			out.close();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
