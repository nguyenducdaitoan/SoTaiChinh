package vn.softech.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger(ExecuteTimeInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug("preHandle called");
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

	// after the handler is executed
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.debug("postHandle called");
		logger.debug("startTime: " + request.getAttribute("startTime"));
		if (request.getAttribute("startTime") != null) {
			long startTime = (Long) request.getAttribute("startTime");
			long endTime = System.currentTimeMillis();
			long executeTime = endTime - startTime;
			if (modelAndView != null) {
				modelAndView.addObject("executeTime", executeTime);
			}
			// log it
//			if (logger.isDebugEnabled()) {
				logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
//			}
		}
	}
}