package com.tomjava.kurs.spirng.domain;

public class Quest {
    private String desripcrion;

    public Quest(String desripcrion) {
        this.desripcrion = desripcrion;
    }

    @Override
    public String toString() {
        return desripcrion;
    }
}

