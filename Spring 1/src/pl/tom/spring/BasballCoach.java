package pl.tom.spring;

public class BasballCoach implements Coach {

    private LoterryService loterryService;

    public BasballCoach(LoterryService loterryService) {
        this.loterryService = loterryService;
    }

    @Override
    public String getBasballName() {
        return "to jest metoda getBasball w klasie Basball";
    }

    @Override
    public String getDailyLottery() {
        return loterryService.getLottery();
    }
}
