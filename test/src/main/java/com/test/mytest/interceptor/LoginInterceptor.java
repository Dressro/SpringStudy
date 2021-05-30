package com.test.mytest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("[interceptor] : preHandle");
		if (request.getRequestURI().contains("/loginform.do")) {
			return true;
		} else if (request.getRequestURI().contains("/ajaxlogin.do")) {
			return true;
		} else if (request.getSession().getAttribute("login") != null) {
			return true;
		} else if (request.getRequestURI().contains("/test.do")) {
			return true;
		} else if (request.getRequestURI().contains("/memberinsertform.do")) {
			return true;
		} else if (request.getRequestURI().contains("/registres.do")) {
			return true;
		}

		if (request.getSession().getAttribute("login") == null) {
			response.sendRedirect("loginform.do");
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("[Interceptor] : postHandle");

		if (modelAndView != null) {
			logger.info("target View : " + modelAndView.getViewName());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("[Interceptor] : afterCompletion");
	}

}
