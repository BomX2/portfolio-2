package utils;

import model.Azc;
import model.AzcMedewerker;
import model.Gemeente;
import model.Observable;

import java.util.ArrayList;

public class Gemeentes {
    private ArrayList<Gemeente> gemeentes;
    private Observable observable;

    public Gemeentes(Observable observable) {
        this.gemeentes = new ArrayList<>();
        this.observable = observable;

    }

    public void initializeGemeentes(){
        Gemeente denHaag = new Gemeente("den haag", 514861);
        gemeentes.add(denHaag);

        Azc azc = new Azc("laan van noi",6,"6542 AB");
        denHaag.addAzcs(azc);
        observable.addObserver(azc);
    }

    public void setGemeentes (Gemeente gemeente) {
        gemeentes.add(gemeente);
    }

    public ArrayList<Gemeente> getGemeentes() {
        return gemeentes;
    }

    public void setGemeentes(ArrayList<Gemeente> gemeentes) {
        this.gemeentes = gemeentes;
    }
    public Gemeente getGemeente (String naam) {
        for(Gemeente gemeente : gemeentes) {
            if (gemeente.getNaam().equalsIgnoreCase(naam)){
                return gemeente;
            }
        }
        return null;

    }
}
