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
        kamer.verlaagCapaciteit();
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
                return true;
            }
        }
        return false;
    }

    public void assignRoomToRefugee(Asielzoeker asielzoeker) {
        for (Kamer room : kamers) {
            if (ispassend(room, asielzoeker)) {
                this.vluchtelingen.add(asielzoeker);
            }
        }
    }

    private boolean ispassend(Kamer kamer, Asielzoeker asielzoeker) {
        // Decision point 1: Is the refugee part of a family and is the room a family room with sufficient capacity?
        if (asielzoeker.isFamilielid() && kamer instanceof GezinsKamer && kamer.getCapaciteit() >= 2) {
            return true;
        }
        // Decision point 2: Is the room a single room with one bed, and does the gender match?
        if (kamer instanceof GewoneKamer && kamer.getCapaciteit() == 1 && kamer.getGender().equals(asielzoeker.getGender())) {
            return true;
        }
        // Decision point 3: Is the room a youth room and is the refugee under 18?
        if (kamer instanceof JongerenKamer && asielzoeker.getLeeftijd() >= 18) {
            return true;
        }
        // Decision point 4: Is the room a general room and does the safety status match?
        if (kamer instanceof GewoneKamer && kamer.isBestemdVoorVeilig() == asielzoeker.getLandVanHerkomst().isVeilig()) {
            return true;
        }
        return false;
    }

    @Override
    public void update(Bericht bericht) {
        berichtenbox.voegBericht(bericht);
        System.out.println("AZC " + straat + " heeft een nieuw bericht ontvangen.");
    }
}
