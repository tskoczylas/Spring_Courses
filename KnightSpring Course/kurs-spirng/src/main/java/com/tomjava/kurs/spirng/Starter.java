package com.tomjava.kurs.spirng;

import com.tomjava.kurs.spirng.domain.repository.InMemoryRepository;
import com.tomjava.kurs.spirng.domain.repository.KnightResoiratory;
import com.tomjava.kurs.spirng.domain.repository.QuestRespository;
import com.tomjava.kurs.spirng.domain.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("singleton")
@Component
public class Starter implements CommandLineRunner {
    @Autowired
KnightResoiratory knightResoiratory;
@Autowired
    QuestRespository questRespository;
@Autowired
    QuestService questService;



    @Override
    public void run(String... args) throws Exception {


      //  questService.assignRandomQest("Lancelot");
     //   questService.assignRandomQest("Albowski");







    }
}
