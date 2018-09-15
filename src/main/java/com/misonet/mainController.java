package com.misonet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {
	
	
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String changeKakfaTopicName(@RequestParam String name) {

        return "success";
    }
}
