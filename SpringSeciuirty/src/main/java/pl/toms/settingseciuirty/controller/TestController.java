package pl.toms.settingseciuirty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test1")
    public String get(){

        return "test1";
    }
    @GetMapping("/test2")
    public String get2(){

        return "test2";
    } @GetMapping("/test3")
    public String get3(){

        return "test3";
    } @GetMapping("/test4")
    public String get4(){

        return "test4";
    }
}
