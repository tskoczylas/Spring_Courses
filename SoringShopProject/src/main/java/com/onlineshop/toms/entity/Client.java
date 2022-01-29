package com.onlineshop.toms.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client_order")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "address")
    @NotBlank
    @Size(min = 10,message = "Adres musi zawierac conajmniej 10 symboli")
    private String adress;

    @Column(name = "telephone")
    private int telephone;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private OrderStatus orderStatus;


    public Client(int id, @NotBlank @Size(min = 10, message = "Adres musi zawierac conajmniej 10 symboli") String adress, int telephone, OrderStatus orderStatus, List<Item> itemList) {
        this.id = id;
        this.adress = adress;
        this.telephone = telephone;
        this.orderStatus = orderStatus;
        this.itemList = itemList;
    }

    @ManyToMany
@JoinTable(name = "order_item",
        joinColumns = @JoinColumn(name = "order_id" ,referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id")
)
    private List<Item> itemList = new ArrayList<>();

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return
               id +
                " " + adress +
                  "  " + telephone +
                "  " + orderStatus +
                "  " + itemList;
    }
}
