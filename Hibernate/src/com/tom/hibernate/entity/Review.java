package com.tom.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "comment")
    private String commnet;


    public Review() {
    }

    public Review(String commnet) {
        this.commnet = commnet;
    }


    public String getCommnet() {
        return commnet;
    }

    public void setCommnet(String commnet) {
        this.commnet = commnet;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", commnet='" + commnet + '\'' +
                '}';
    }
}
