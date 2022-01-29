package com.tomsapp.seciurity2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ImageStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String url;


    public ImageStore( String url) {
        this.url = url;
    }

    public ImageStore() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
