package com.kosa.mycompany.common;

import javax.servlet.http.HttpServletRequest;

public class pager {
	public static String makeTag(HttpServletRequest request, int totalCnt, int pgSize) {
		
		//어떤 페이지는 한 페이지당 10개씩이고 어떤페이지는 16개씩이고..
		int pgGroupSize=5; //한 그룹당 5개씩 보겠다
		int cpage; //현재 페이지
		String pg=request.getParameter("pg");
		if(pg==null||pg==("")) {
			pg="0";
		}
		cpage = Integer.parseInt(pg); //현재 페이지 정보 저정하기
		int pageTotal = (int)Math.ceil((double)totalCnt/pgSize); 
		//total =>float형으로 전환하면 pgSize도 float으로 전환해서
		//연산을 수행한다. 327.0/10.0 => ceil(32.7) => 33.0 => 33
		System.out.println(pageTotal);
		
		String firstLabel = "first";
		String prevLabel = "prev";
		String nextLabel = "next";
		String lastLabel = "last";
		
		int start, end;
		//0~4
		//5~9
		//10~14...
		start = cpage/pgGroupSize*pgGroupSize;
		end = start + pgGroupSize;
		if(end>pageTotal)
			end = pageTotal;
		System.out.println(String.format("start %d end %d cpage %d", start, end, cpage));
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("<ul class='pagination justify-content-center'>");
		buffer.append(makeLink(0, firstLabel));
		
		if(cpage>0)
			buffer.append(makeLink(cpage-1, prevLabel));
		for (int i = start; i < end; i++) {
			if(i==cpage)
			buffer.append(makeActiveLink(i, (i+1)+""));
			else
				buffer.append(makeLink(i, (i+1)+""));
		}
		if(cpage<pageTotal-1)
		buffer.append(makeLink(cpage+1, nextLabel));
		buffer.append(makeLink(pageTotal-1, lastLabel));
		buffer.append("</ul>");
		return buffer.toString();
	}
	
	static String makeLink(int page, String label) {
		String s = "<li class='page-item'>"+"<a class='page-link' href='#none' onclick=goPage("+page+")>"+label+"</a></li>";
		return s;
	}
	
	static String makeActiveLink(int page, String label) {
		String s = "<li class='page-item active'>"+"<a class='page-link' href='#none' onclick=goPage("+page+")>"+label+"</a></li>";
		return s;
	}
}
