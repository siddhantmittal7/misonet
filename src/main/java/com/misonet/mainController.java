package com.misonet;

import java.util.List;

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

@Controller
public class mainController {
	
	@Autowired
	IUserProfileMao IUserProfileMao;
	
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String changeKakfaTopicName(@RequestParam String name) {

    //    	IUserProfileMao.insertNewUser();
   //IUserProfileMao.insertNewUser();
        return "success";
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
