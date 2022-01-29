package com.tom.hibernate.demo;

import com.tom.hibernate.entity.Course;
import com.tom.hibernate.entity.Instructor;
import com.tom.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CreateDemo2 {
    public static void main(String[] args) {

        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 1);
            Course  course=new Course("rrr");
            Course course1 = new Course("5fg");
            List<Course> coursesList=new ArrayList<>();
            coursesList.add(course);
            coursesList.add(course1);

            instructor.setCourses(coursesList);


            session.save(course);
            session.save(course1);



            session.getTransaction().commit();

        }

        finally {
            session.close();
            factory.close();
        }



    }
}
