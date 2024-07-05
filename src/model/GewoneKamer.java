package model;

public class GewoneKamer extends Kamer{
    boolean bestemdVoorVeilig;
    public GewoneKamer(int capaciteit, String gender, String bestemming,boolean bestemdVoorVeilig) {
        super(capaciteit, gender, bestemming);
        this.bestemdVoorVeilig = bestemdVoorVeilig;
    }
}
