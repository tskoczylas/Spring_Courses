package pl.tom;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnationBeanScopeDemoApp  {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach = context.getBean("tennisCoach",Coach.class);

        Coach alphacoach = context.getBean("tennisCoach",Coach.class);
        System.out.println(coach==alphacoach);
        System.out.println(coach);
        System.out.println(alphacoach);

        context.close();
    }
}
