package model;

import java.util.ArrayList;

public class Gemeente {
    private String naam;
    private int inwoners;

    private ArrayList<Azc> azcs;

    public Gemeente (String naam, int inwoners){
        this.inwoners = inwoners;
        this.naam = naam;
        azcs = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getInwoners() {
        return inwoners;
    }

    public void setInwoners(int inwoners) {
        this.inwoners = inwoners;
    }

    public ArrayList<Azc> getAzcs() {
        return azcs;
    }
    public Azc getAzc (String postcode) {
        for(Azc azc : azcs) {
            if (azc.getPostcode().equals(postcode)){
                return azc;
            }
        }
        return null;

    }

    public void addAzcs(Azc azcs) {
        this.azcs.add(azcs);
    }
}
