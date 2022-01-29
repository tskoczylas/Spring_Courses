package com.tomjava.kurs.spirng.Controller;

import com.tomjava.kurs.spirng.domain.Knight;
import com.tomjava.kurs.spirng.domain.repository.KnightResoiratory;
import com.tomjava.kurs.spirng.domain.services.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService service;

    @RequestMapping("/knights")
    public String getKnight(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("hello", "witaj świecie");
        return "knights";
    }

    @RequestMapping("/newknight")

    public String createKnight(Model model){
        model.addAttribute("knight",new Knight());
        return "newknight";
    }

}
