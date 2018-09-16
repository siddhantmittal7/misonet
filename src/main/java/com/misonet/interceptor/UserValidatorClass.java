package com.misonet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.misonet.utils.RequestContextService;

@Component
public class UserValidatorClass extends HandlerInterceptorAdapter {

    @Autowired
    RequestContextService requestContextService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {


        if (request.getRequestURI().contains("login")) {
        	
            return true;
        }

        String userid = "";
        
        userid = requestContextService.validateCMUser(request);


        if (userid != null) {
        	return true;
        } else {
            response.sendRedirect("");
            return false;
            
            
        }
        
    }
    
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	   	 response.setHeader("Access-Control-Allow-Origin", "*");
		    response.setHeader("Access-Control-Allow-Methods",
		            "POST, GET, OPTIONS,PUT, HEAD, DELETE");
		    response.setHeader("Access-Control-Max-Age", "3600");
		    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		    response.setHeader("Access-Control-Allow-Credentials", "true");
	        

	}
    
}