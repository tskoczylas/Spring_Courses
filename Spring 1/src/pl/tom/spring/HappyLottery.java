package pl.tom.spring;

public class HappyLottery implements LoterryService {
    @Override
    public String getLottery() {
        return "Masz szczęśliwy dzień";
    }
}
