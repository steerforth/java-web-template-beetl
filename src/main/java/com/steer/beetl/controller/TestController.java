package com.steer.beetl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("")
    public ModelAndView helloBeetl(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","lining");
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
