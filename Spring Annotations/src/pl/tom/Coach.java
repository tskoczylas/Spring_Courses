package pl.tom;


import java.io.FileNotFoundException;

public interface Coach {
    String getDailyWorkaut();
    String getDailyFortune() throws FileNotFoundException;
}
