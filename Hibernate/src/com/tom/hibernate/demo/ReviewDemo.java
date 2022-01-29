package com.tom.hibernate.demo;

import com.tom.hibernate.entity.Course;
import com.tom.hibernate.entity.Instructor;
import com.tom.hibernate.entity.InstructorDetail;
import com.tom.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class ReviewDemo {
    public static void main(String[] args) {

        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();

        try {
            session.beginTransaction();

            Review review = session.get(Review.class, 11);


            session.delete(review);




            session.getTransaction().commit();

        }

        finally {
            session.close();
            factory.close();
        }



    }
}
