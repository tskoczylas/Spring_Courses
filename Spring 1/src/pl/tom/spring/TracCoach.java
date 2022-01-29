package pl.tom.spring;

public class TracCoach implements Coach {
 LoterryService loterryService;

    public TracCoach(LoterryService loterryService) {
        this.loterryService = loterryService;
    }

    @Override
    public String getBasballName() {
        return "to jest metoda getBasballName w klasi TRACK COACH";
    }

    @Override
    public String getDailyLottery() {
        return loterryService.getLottery();
    }
}
