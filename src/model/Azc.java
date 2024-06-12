package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Azc implements Observer {
    private String straat;
    private int nummer;
    private String postcode;
    private Gemeente gemeente;
    private Berichtenbox berichtenbox;
    private ArrayList<Asielzoeker> vluchtelingen;
    private ArrayList<Kamer> kamers;

    public Azc (String straat,int nummer,String postcode, Gemeente gemeente) {
        this.straat = straat;
        this.nummer = nummer;
        this.postcode = postcode;
        this.gemeente = gemeente;
        vluchtelingen = new ArrayList<>();
    }

    public Gemeente getGemeente() {
        return gemeente;
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

    public void setGemeente(Gemeente gemeente) {
        this.gemeente = gemeente;
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

    @Override
    public void update(Observable o, Object arg) {

    }
}
