package com.onlineshop.toms.entity;

public enum OrderStatus {
    NEW("Nowe zamowienie"), IN_PROGRESS("W produkcji"),COMPLETE("Zakończone");

String descritpion;

     OrderStatus(String descritpion) {
        this.descritpion = descritpion;
    }

    public String getDescritpion() {
        return descritpion;
    }


public static OrderStatus geNextOrder(OrderStatus orderStatus)  {
        if(orderStatus==NEW) return IN_PROGRESS;
        else if(orderStatus==IN_PROGRESS) return COMPLETE;
        else throw  new IllegalArgumentException("There is no next status");
    }


}
