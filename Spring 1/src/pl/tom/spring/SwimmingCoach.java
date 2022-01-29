package pl.tom.spring;

public class SwimmingCoach implements Coach  {
    @Override
    public String getBasballName() {
        return "To jest swwimming coACH";
    }

    @Override
    public String getDailyLottery() {
        return null;
    }
}
