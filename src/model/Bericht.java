package model;

public class Bericht {
    private String onderwerp;
    private String naam;
    private String info;

    public Bericht (String onderwerp, String naam, String info){
        this.naam = naam;
        this.onderwerp = onderwerp;
        this.info = info;
    }

    public String getNaam() {
        return naam;
    }

    public String getOnderwerp() {
        return onderwerp;
    }

    public String getInfo() {
        return info;
    }
}
