package com.tomjava.kurs.spirng.domain.repository;

import com.tomjava.kurs.spirng.domain.Knight;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("prod")
public class InMemoryRepository implements KnightResoiratory {



    Map<String, Knight> knights = new HashMap<>();



    @Override
    public void createKnights(String name, int age){
        knights.put(name,new Knight(name,age));
    }

    @Override
    public Collection<Knight> getAllKnights(){
        return knights.values();
    }
     @Override
     public Knight getKnight(String name){
       return knights.get(name);

     }

     @Override
     public void  deleteKnight(String name){
        knights.remove(name);
     }



@PostConstruct
@Override
public void bulid(){
createKnights("Lancelot",33);
createKnights("Albowski",37);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }



}
