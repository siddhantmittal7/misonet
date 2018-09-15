package com.misonet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.misonet.model.ApiResponse;
import com.misonet.model.SuccessResponse;
import com.misonet.model.UserProfile;
import com.misonet.model.mao.IUserProfileMao;
import com.misonet.utils.RequestContextService;

@Controller
public class mainController {

@Autowired
IUserProfileMao IUserProfileMao;

@Autowired
RequestContextService requestContextService;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String changeKakfaTopicName(@RequestParam String name) {

    //IUserProfileMao.insertNewUser();
        return "success";
    }
    
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public ApiResponse<String> login(@RequestParam String email, @RequestParam String password,
    @RequestParam HttpServletResponse response) {

    String userid = IUserProfileMao.login(email,password);
    	
    ApiResponse<String> apiResponse = null;
    if(userid != null) {
    	apiResponse = new SuccessResponse<String>(userid,
                 200, "OK");
     
    	try {
requestContextService.createCookie(userid, response);
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
    }else {
    	apiResponse = new SuccessResponse<String>("",
                 500, "OK");
    }
        return apiResponse;
    }
    
    @RequestMapping(value = "/newUser", method = {RequestMethod.POST})
    @ResponseBody
    public ApiResponse<String> addUser(@RequestParam String name,
    @RequestParam List<String> interests){
    	
    	
    UserProfile userProfile = new UserProfile();
    userProfile.setName(name);
    userProfile.setInterests(interests);
    	
    String id = IUserProfileMao.insertNewUser(userProfile);
    	
    	ApiResponse<String> apiResponse = new SuccessResponse<String>(id,
                200, "OK");
     
    	return apiResponse;
    }
}