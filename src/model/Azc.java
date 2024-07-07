package model;

import java.util.ArrayList;
import java.util.Observable;
import model.*;

public class Azc implements Observer {
    private String straat;
    private int nummer;
    private String postcode;
    private Berichtenbox berichtenbox;
    private ArrayList<Asielzoeker> vluchtelingen;
    private ArrayList<Kamer> kamers;

    public Azc (String straat,int nummer,String postcode) {
        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;
        vluchtelingen = new ArrayList<>();
        berichtenbox = new Berichtenbox();
        kamers = new ArrayList<>();
    }

    public int getNummer() {
        return nummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getStraat() {
        return straat;
    }

    public ArrayList<Asielzoeker> getVluchtelingen() {
        return vluchtelingen;
    }
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setVluchtelingen(ArrayList<Asielzoeker> vluchtelingen) {
        this.vluchtelingen = vluchtelingen;
    }
    public void voegVluchtelingToe (Asielzoeker asielzoeker){
        vluchtelingen.add(asielzoeker);
    }
    public void removeVluchteling (Asielzoeker asielzoeker){
        vluchtelingen.remove(asielzoeker);
    }

    public Berichtenbox getBerichtenbox() {
        return berichtenbox;
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }

    public void addKamers(Kamer kamer) {
        kamers.add(kamer);
    }

    public boolean plaatsAsiel (Asielzoeker asielzoeker){
        for (Kamer kamer : kamers){
            boolean A = kamer.getCapaciteit() > 0;
            boolean B = (kamer instanceof GezinsKamer && asielzoeker.isFamilielid()) || (kamer instanceof JongerenKamer && asielzoeker.getLeeftijd() < 18)
                                   || (kamer instanceof GewoneKamer && asielzoeker.getLeeftijd() >= 18 && !asielzoeker.isFamilielid());
            boolean C = kamer.getGender().equals(asielzoeker.getGender()) || kamer.getGender().equals("");
            if (A && B && C) {
                this.vluchtelingen.add(asielzoeker);
                kamer.verlaagCapaciteit();
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Bericht bericht) {
        berichtenbox.voegBericht(bericht);
        System.out.println("AZC " + straat + " heeft een nieuw bericht ontvangen.");
    }
}
