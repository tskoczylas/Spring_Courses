package com.tom.hibernate.demo;

import com.tom.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.rmi.CORBA.Stub;
import java.util.ArrayList;
import java.util.List;

public class CreateCourseandStudentDemo {
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
            Course course = new Course("php");

            session.save(course);

            Studnet studnet = new Studnet("Anna","Wolska","t@wp.pl");
            Studnet studnet1 = new Studnet("Kowal","Powal","w.pl");
            List<Studnet> studnets = new ArrayList<>();
            studnets.add(studnet);
            studnets.add(studnet1);

            course.setStudnets(studnets);

            session.save(studnet);
            session.save(studnet1);




            session.getTransaction().commit();

        }

        finally {
            session.close();
            factory.close();
        }



    }
}
