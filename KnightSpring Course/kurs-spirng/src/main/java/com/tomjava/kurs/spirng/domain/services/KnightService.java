package com.tomjava.kurs.spirng.domain.services;


import com.tomjava.kurs.spirng.domain.Knight;
import com.tomjava.kurs.spirng.domain.repository.KnightResoiratory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KnightService {

    @Autowired
    KnightResoiratory knightResoiratory;


   public  List<Knight> getAllKnights(){

        return new ArrayList<>(knightResoiratory.getAllKnights());


    }




}
