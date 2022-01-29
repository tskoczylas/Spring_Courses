package com.tomsapp.Toms.V2.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Books {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;



    @Column(name = "title")
   private String title;
    @Column(name = "author")
   private String author;
    @Column(name = "ibns")
   private String ibns;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "student_id")
    Students manyStudents;

    public Books() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIbns() {
        return ibns;
    }

    public void setIbns(String ibns) {
        this.ibns = ibns;
    }

    public Students getManyStudents() {
        return manyStudents;
    }

    public void setManyStudents(Students manyStudents) {
        this.manyStudents = manyStudents;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ibns='" + ibns + '\'' +
                ", manyStudents=" + manyStudents ;
    }
}
