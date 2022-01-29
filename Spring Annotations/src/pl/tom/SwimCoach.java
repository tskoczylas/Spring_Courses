package pl.tom;

import java.io.FileNotFoundException;

public class SwimCoach  implements Coach {
   FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkaut() {
        return "Swimm 100 m";
    }

    @Override
    public String getDailyFortune() throws FileNotFoundException {
        return fortuneService.getDailFortune();
    }
}
