package pl.tom;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        Coach coach = context.getBean("swimCoach", Coach.class);

        System.out.println(coach.getDailyWorkaut());


        context.close();


    }
}
