package com.tom.hibernate.demo;

import com.tom.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetCourseandStudentDemo {
    public static void main(String[] args) {

        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Studnet.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();

        try {
            session.beginTransaction();

          Studnet studnet = session.get(Studnet.class,1);
          session.delete(studnet);

          session.getTransaction().commit();

        }

        finally {
            session.close();
            factory.close();
        }



    }
}
