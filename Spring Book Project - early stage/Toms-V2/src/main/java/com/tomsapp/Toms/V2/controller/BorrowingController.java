package com.tomsapp.Toms.V2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;

@Controller
@RequestMapping("/borrowing")
public class BorrowingController {


    @GetMapping("/list")
    public String showList(){


        return "showBorrowingForm";
    }

}
