package vn.softech.spring.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestInitializeInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger(RequestInitializeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug("preHandle called");
		try {
			logger.info("Intercepting: " + request.getRequestURI());
			if (!("/admin/login.html".equals(request.getRequestURI())) && (request.getRequestURI().indexOf("/admin/") == 0)) {
				HttpSession session = request.getSession(false);
	    		Boolean isLogin = Boolean.FALSE;
	    		if ((session != null) && (session.getAttribute("isLogin") != null)) {
	    			isLogin = (Boolean)session.getAttribute("isLogin");
	    		}
//	    		log.debug("isLogin: " + isLogin);
	    		if (!isLogin.booleanValue()) {
//	   				response.setHeader("Location", "/login.do");
	    			try {
						response.sendRedirect("/admin/login.html");
						return false;
					} catch (IOException e) {
						e.printStackTrace();
					}
	    		}
			}
			return true;
		} catch (Exception e) {
			logger.info("request update failed");
			e.printStackTrace();
			return false;
		}
	}
}
