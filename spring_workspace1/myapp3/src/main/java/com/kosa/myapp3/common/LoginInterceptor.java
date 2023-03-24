package com.kosa.myapp3.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//인터셉터
//HandlerInterceptorAdapter
public class LoginInterceptor extends HandlerInterceptorAdapter {

	// /board/write -> LoginIntercepter의 preHandler를 들렸다 간다
	// 로그온 여부의 따라 로그온 페이지로 보낼지 아니면 그냥 컨트롤러로 보낼지 결정해야 한다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션 객체를 가져와 로그온 하였는지 여부를 판단한다.
		HttpSession session = request.getSession();
		System.out.println("모두 여기 거쳐감");

		// 반드시 로그인해야 하는 경우가 아닌 url을 등록한다.
		List<String> excludeChekList = new ArrayList<String>();
		excludeChekList.add("/board/list");
		excludeChekList.add("/board/view");
		excludeChekList.add("/member/login");
		excludeChekList.add("/member/loginproc");
		excludeChekList.add("/member/logout");
		excludeChekList.add("/");

		String currentUrl = request.getRequestURI();// /board/list
		System.out.println(request.getRequestURI());
		currentUrl = currentUrl.replace("/myapp3", "");
		
		if (excludeChekList.indexOf(currentUrl) == -1) {
			String user_id = (String) session.getAttribute("user_id");
			if (user_id == null || user_id.equals("")) {
				String url = request.getContextPath() + "/member/login";
				response.sendRedirect(url);
				return false; // 로그온 안했을 때
				// 로그온 페이지로 이동한다. - 로그온 배제 리스트에 없으면 로그인 페이지로 먼저 이동

			}
		}

		// 부모클래스의 함수를 호출해야 한다.
		return super.preHandle(request, response, handler);
	}

}
