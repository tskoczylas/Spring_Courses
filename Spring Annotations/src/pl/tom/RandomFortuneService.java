package pl.tom;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{

    private String[] texts={"Pierszy akapit random",
            "Drugi akapit random",
            "Trzeci akapit random"
    };

   private Random random = new Random();



    @Override
    public String getDailFortune() {
        return texts[random.nextInt(texts.length)];

    }
}
