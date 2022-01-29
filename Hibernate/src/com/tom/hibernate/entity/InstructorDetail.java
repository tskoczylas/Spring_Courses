package com.tom.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
 private int id;

@Column(name = "youtube_channel")
private String youTubeChanell;
@Column(name = "hobby")
    private String hobby;

@OneToOne(mappedBy = "instructorDetail",
        cascade = {CascadeType.DETACH,
        CascadeType.PERSIST,
        CascadeType.REFRESH})

        private Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public InstructorDetail(String youTubeChanell, String hobby) {
        this.youTubeChanell = youTubeChanell;
        this.hobby = hobby;
    }

    public InstructorDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYouTubeChanell() {
        return youTubeChanell;
    }

    public void setYouTubeChanell(String youTubeChanell) {
        this.youTubeChanell = youTubeChanell;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youTubeChanell='" + youTubeChanell + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
