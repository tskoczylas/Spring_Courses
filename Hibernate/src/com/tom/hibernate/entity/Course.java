package com.tom.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "title")
    private String title;
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,
            CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany (cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private List<Review> reviewList;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE}, fetch = FetchType.LAZY)
            @JoinTable(
                    name = "course_student",
                    joinColumns = @JoinColumn(name = "course_id"),
                    inverseJoinColumns = @JoinColumn(name = "student_id")
            )
    List<Studnet> studnets;

    public List<Studnet> getStudnets() {
        return studnets;
    }

    public void setStudnets(List<Studnet> studnets) {
        this.studnets = studnets;
    }

    public Course(String title) {
        this.title = title;
    }

    public Course() {
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

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title;

    }
    public void add(Review review) {

        if (reviewList==null){
            reviewList=new ArrayList<>();
        }
        reviewList.add(review);


    }

}
