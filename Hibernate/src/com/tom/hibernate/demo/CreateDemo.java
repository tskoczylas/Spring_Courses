package com.tom.hibernate.demo;

import com.tom.hibernate.entity.Course;
import com.tom.hibernate.entity.Instructor;
import com.tom.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {

        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
                    .addAnnotatedClass(Course.class)
        .buildSessionFactory();

        Session session=factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor instructor = new Instructor("Wal", "Slins", "sss@wp.pl");
            InstructorDetail instructorDetail = new InstructorDetail("dobrykanal","gamer");

            instructor.setInstructorDetail(instructorDetail);

session.save(instructor);

            session.getTransaction().commit();

        }

        finally {
            session.close();
            factory.close();
        }



    }
}
