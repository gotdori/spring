package com.kosa.myapp3.common;

public class StringUtil {
	//생성자 private로 만들어서 객체 생성 못하게
	private StringUtil() {}
	
	public static String nullToValue(Object obj, String value) {
		if(obj==null)
			return value;
		else //null이 아닐 경우에 obj -> String 값을 전달
			return obj.toString();
		
		//String 객체에만 사용 가능하다.
		//객체 안만들고 함수 사용이 가능하게 하기위새 static 키워드를 붙임
	}
	//DB에 ' -> " 바꿔서 넣어야 한다.
	
}
