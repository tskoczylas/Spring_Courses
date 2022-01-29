package pl.tom;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;

public class AnnotationDemoApp {
    public static void main(String[] args) throws FileNotFoundException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = context.getBean("tennisCoach",Coach.class);

        System.out.println(coach.getDailyWorkaut());
        System.out.println(coach.getDailyFortune());


        context.close();






    }
}
