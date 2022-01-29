package pl.tom;

import org.springframework.stereotype.Component;

@Component
public class GymCoach implements Coach{
    @Override
    public String getDailyWorkaut() {
        return "Cwicz na silowni";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
