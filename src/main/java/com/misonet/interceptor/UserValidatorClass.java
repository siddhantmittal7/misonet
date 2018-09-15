package com.misonet.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.misonet.serverless.demo.model.ServerlessInput;
import com.misonet.serverless.demo.model.ServerlessOutput;
import com.misonet.utils.RequestContextService;

@Component
public class UserValidatorClass extends HandlerInterceptorAdapter implements RequestHandler<ServerlessInput, ServerlessOutput>{

    @Autowired
    RequestContextService requestContextService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

    	 response.setHeader("Access-Control-Allow-Origin", "*");
    	    response.setHeader("Access-Control-Allow-Methods",
    	            "POST, GET, OPTIONS,PUT, HEAD, DELETE");
    	    response.setHeader("Access-Control-Max-Age", "3600");
    	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
    	    response.setHeader("Access-Control-Allow-Credentials", "true");

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
	public ServerlessOutput handleRequest(ServerlessInput input, Context context) {
		// TODO Auto-generated method stub
		
		System.out.println("In handleRequest");
		ServerlessOutput so = new ServerlessOutput();
		Map<String, String> headers = new HashMap<>();
		headers.put("Access-Control-Allow-Origin", "http://localhost:3000");
		headers.put("Access-Control-Allow-Methods",
	            "POST, GET, OPTIONS,PUT, HEAD, DELETE");
		headers.put("Access-Control-Max-Age", "3600");
		headers.put("Access-Control-Allow-Headers", "Content-Type");
		headers.put("Access-Control-Allow-Credentials", "true");
		so.setHeaders(headers);
		return so;
	}
	
	
	public static Map<String, String> getResponseHeaders() {
		 
		Map<String, String> headers = new HashMap<>();
        headers.put("Access-Control-Allow-Origin", "*");
   		headers.put("Access-Control-Allow-Methods",
   	            "POST, GET, OPTIONS,PUT, HEAD, DELETE");
   		headers.put("Access-Control-Max-Age", "3600");
   		headers.put("Access-Control-Allow-Headers", "Content-Type");
   		headers.put("Access-Control-Allow-Credentials", "true");
   		return headers;
	}
    
}