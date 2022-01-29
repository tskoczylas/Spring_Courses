package com.tom.hibernate.demo;

import com.tom.hibernate.entity.Instructor;
import com.tom.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCreateDemo {
    public static void main(String[] args) {

        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
        .buildSessionFactory();

        Session session=factory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1);
            session.delete(instructor);

            session.getTransaction().commit();

        }

        finally {
            session.close();
        }



    }
}
