package com.tomjava.kurs.spirng.domain.services;

import com.tomjava.kurs.spirng.domain.Quest;
import com.tomjava.kurs.spirng.domain.repository.InMemoryRepository;
import com.tomjava.kurs.spirng.domain.repository.KnightResoiratory;
import com.tomjava.kurs.spirng.domain.repository.QuestRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class QuestService {


    @Autowired
    KnightResoiratory knightResoiratory;

    @Autowired
    QuestRespository questRespository;




    Random random= new Random();


    public void assignRandomQest(String knightName){
        Quest randomQest = questRespository.getAll().get(random.nextInt(questRespository.getAll().size()));
        knightResoiratory.getKnight(knightName).setQuest(randomQest);
        questRespository.deleteQuest(randomQest);

    }



}
