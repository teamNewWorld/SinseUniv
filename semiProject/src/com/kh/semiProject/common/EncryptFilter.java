package com.kh.semiProject.common;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.kh.semiProject.common.EncryptWrapper;


@WebFilter({"/mUpdate.do", "/login.do", "/main.do", "/loginCheck.do", "/pwdSet.do", "/goPwdSet.do"})
public class EncryptFilter implements Filter {


    public EncryptFilter() {
     
    }


	public void destroy() {
	
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 서블릿에 도착하기 전 수행할 코드
		// 원본 request 받기
		HttpServletRequest req = (HttpServletRequest)request;
				
		// 비밀번호 확인용 값 저장
		request.setAttribute("originPwd", req.getParameter("userPwd"));
				
		// 암호화 모듈 적용하기 (필터 안에서 수행할 래퍼 작성하기)
		EncryptWrapper ew = new EncryptWrapper(req);
		chain.doFilter(ew, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
