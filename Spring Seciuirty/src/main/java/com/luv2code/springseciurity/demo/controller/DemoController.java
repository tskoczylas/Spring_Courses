package com.luv2code.springseciurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {



    @GetMapping("/")
    public String starter(){


        return "home";
    }


}
