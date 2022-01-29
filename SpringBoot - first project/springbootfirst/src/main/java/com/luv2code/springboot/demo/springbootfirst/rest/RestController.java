package com.luv2code.springboot.demo.springbootfirst.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Value("${coach.name}")
    private String coach;

    @Value("${team.name}")
    private String team;


    @GetMapping("/team")
    public String getTeam(){

        return team   +" " + coach;
    }




    @GetMapping("/")
    public String sayHello(){

        return "Witaj aktualny czas to " + LocalDateTime.now() + "v2.0";

    }

    @GetMapping("/workout")
    public String workout(){

        return "witaj";

    }

    @GetMapping("/work")
    public String won(){

        return "witaj";

    }

}
