package com.steer.beetl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("")
    public String helloBeetl(HttpServletRequest request){
        request.setAttribute("username","lilei");
        request.setAttribute("content","我是ajax加载前内容");
        return "test.html";
    }

    @GetMapping("/json")
    @ResponseBody
    public String jsonStr(HttpServletRequest request){
        return "{\"name\":\"lilei\"}";
    }

    @GetMapping("/ajax")
    public String helloBeetl2(HttpServletRequest request){
        request.setAttribute("content","我是ajax加载后内容");
        return "test.html#ajaxTest";
    }
}
