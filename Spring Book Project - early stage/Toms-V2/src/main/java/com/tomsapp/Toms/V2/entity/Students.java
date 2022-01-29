package com.tomsapp.Toms.V2.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Students {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private int id;
@Column(name = "first_name")
    private String firstName;
@Column(name = "last_name")
    private String lastName;


@OneToMany(mappedBy = "manyStudents", cascade = CascadeType.REFRESH)
List<Books> books;

@OneToMany(mappedBy = "adressStudents",cascade = CascadeType.ALL)
List<Adress> adresses;

    public Students(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Students() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return
                firstName + " " +
                lastName;
    }
}
