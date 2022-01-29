package pl.tom.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new
                ClassPathXmlApplicationContext("applicationContext.xml");
    Coach coach= context.getBean("trening",Coach.class);

        System.out.println(coach.getBasballName());
        System.out.println(coach.getDailyLottery());
        context.close();

    }
}
