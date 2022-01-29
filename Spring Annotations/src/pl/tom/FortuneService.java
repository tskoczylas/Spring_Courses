package pl.tom;

import java.io.FileNotFoundException;

public interface FortuneService {

    String getDailFortune() throws FileNotFoundException;
}
