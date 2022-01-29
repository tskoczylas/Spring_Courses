package com.tomjava.kurs.spirng.domain.repository;

import com.tomjava.kurs.spirng.domain.Quest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class QuestRespository {
    List<Quest> questsList = new ArrayList<>();

    public void createQest(String desription){
        questsList.add(new Quest(desription));
    }

    public List<Quest> getAll(){
        return questsList;
    }
    public void deleteQuest(Quest quest){
        questsList.remove(quest);

    }

    @PostConstruct
    public void createQuest(){

    }

    @Override
    public String toString() {
        return "QuestRespository{" +
                "questsList=" + questsList +
                '}';
    }

    Random random= new Random();
    @Scheduled(fixedDelayString = "${QuestCreationDeleay}")
    public void CerateRandomQuest(){
        List<String> randomQests=new ArrayList<>();
        randomQests.add("Idz do sklepiu");
        randomQests.add("Cos tam zrob");
        randomQests.add("Idz w choler");
        randomQests.add("Rob co chcesz");
        String desripcrion = randomQests.get(random.nextInt(randomQests.size()));
        System.out.println("Utworzylem zadanie o opisie " + desripcrion);
        questsList.add(new Quest(desripcrion));

    }
}
