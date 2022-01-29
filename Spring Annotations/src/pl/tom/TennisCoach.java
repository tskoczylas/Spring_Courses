package pl.tom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomServiceFromFile")
private FortuneService fortuneService;

    @PostConstruct
public void  doMySTartupStaff(){
        System.out.println("innasie do my start staff");
    }
@PreDestroy
    void duMyCleanUpStaff(){
        System.out.println("insaide do my clyan up stagg");
    }



    @Override
    public String getDailyWorkaut() {
        return "Cwicz tenis";
    }

    @Override
    public String getDailyFortune() throws FileNotFoundException {
        return fortuneService.getDailFortune();
    }
}
