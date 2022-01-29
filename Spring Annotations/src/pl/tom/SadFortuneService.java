package pl.tom;

import java.io.FileNotFoundException;

public class SadFortuneService implements FortuneService {
    @Override
    public String getDailFortune() throws FileNotFoundException {
        return "Today is a sad day";
    }
}
