package pl.tom.spring;

public class CricietCoach implements Coach {
    private String email;
    private String team;

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public LoterryService getLoterryService() {
        return loterryService;
    }

    public void setEmail(String email) {
        System.out.println("wewnatrz zettera mail");
        this.email = email;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    LoterryService loterryService;



    public CricietCoach() {
        System.out.println("w konstruktorze");
    }



    public void setLoterryService(LoterryService loterryService) {
        System.out.println("wenwątrz settera");
        this.loterryService = loterryService;
    }

    @Override
    public String getBasballName() {
        return "circet basball";
    }

    @Override
    public String getDailyLottery() {
        return loterryService.getLottery();
    }


}
