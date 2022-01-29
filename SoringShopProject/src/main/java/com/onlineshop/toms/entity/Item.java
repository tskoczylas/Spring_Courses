package com.onlineshop.toms.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "price")
private double price;

@Column(name = "name")
private String name;

@Column(name = "short_description")
private String shortDescription;

@Column(name = "description")
private String description;

@Column(name = "image_url")
private String imageUrl;




    @ManyToMany
@JoinTable(name = "order_item"
,joinColumns = @JoinColumn(name = "order_id",referencedColumnName = "id")
,inverseJoinColumns = @JoinColumn(name = "item_id",referencedColumnName = "id")
)
private List<Client> itemList=new ArrayList<>();

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Client> getItemList() {
        return itemList;
    }

    public void setItemList(List<Client> itemList) {
        this.itemList = itemList;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



}
