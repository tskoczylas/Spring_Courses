package pl.tom.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        CricietCoach cricietCoach= context.getBean("mycricetCoach",CricietCoach.class);
        System.out.println(cricietCoach.getBasballName());

        System.out.println(cricietCoach.getTeam());
        System.out.println(cricietCoach.getEmail());

        context.close();

    }
}
