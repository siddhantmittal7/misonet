package com.misonet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.misonet.model.mao.IUserProfileMao;

@Controller
public class mainController {
	
	@Autowired
	IUserProfileMao IUserProfileMao;
	
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String changeKakfaTopicName(@RequestParam String name) {

//    	IUserProfileMao.insertNewUser();
        return "success";
    }
}
