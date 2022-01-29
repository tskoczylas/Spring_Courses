package com.tomjava.kurs.spirng.domain.repository;

import com.tomjava.kurs.spirng.domain.Knight;

import java.util.Collection;

public interface KnightResoiratory {
    void createKnights(String name, int age);

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    void  deleteKnight(String name);
    void bulid();

    }
