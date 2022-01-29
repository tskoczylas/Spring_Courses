package com.tomjava.kurs.spirng.domain.repository;

import com.tomjava.kurs.spirng.domain.Knight;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import java.util.Collection;

@Repository
@Profile("dev")
public class DBKnightRepository implements KnightResoiratory {

    @Override
    public void createKnights(String name, int age){
        System.out.println("Uzywam bazy danych");
    }

    @Override
    public Collection<Knight> getAllKnights(){
        System.out.println("Uzywam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    public Knight getKnight(String name){
        System.out.println("Uzywam bazy danych");
throw new NotImplementedException();
    }

    @Override
    public void  deleteKnight(String name){
        System.out.println("Uzywam bazy danych");
    }


    @Override
    @PostConstruct
    public void bulid(){

    }


}
