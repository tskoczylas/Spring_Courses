package pl.tom;

import org.springframework.stereotype.Component;

@Component
public class DatabaseService implements FortuneService {
    @Override
    public String getDailFortune() {
        return null;
    }
}
