package pl.tom;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public String getDailFortune() {
        return "Today is your lucky day";
    }
}
