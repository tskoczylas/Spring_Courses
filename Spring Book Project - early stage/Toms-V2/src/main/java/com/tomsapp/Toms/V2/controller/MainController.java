package com.tomsapp.Toms.V2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {



    @GetMapping("/")
    public String demoController(Model model){

        model.addAttribute("time",new java.util.Date());


        return "start";
    }
}
