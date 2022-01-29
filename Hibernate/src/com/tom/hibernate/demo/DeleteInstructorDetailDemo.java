package com.tom.hibernate.demo;

import com.tom.hibernate.entity.Instructor;
import com.tom.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {

        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                        .addAnnotatedClass(InstructorDetail.class)
        .buildSessionFactory();

        Session session=factory.getCurrentSession();

        try {
            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 3);
instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);

            session.getTransaction().commit();

        }
        catch (NullPointerException ext){
            System.out.println("Nie ma takiego obiektu");
        }

        finally {
            session.close();
            factory.close();
        }



    }
}
