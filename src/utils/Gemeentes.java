package utils;

import model.Azc;
import model.AzcMedewerker;
import model.Gemeente;

import java.util.ArrayList;

public class Gemeentes {
    private ArrayList<Gemeente> gemeentes;

    public Gemeentes() {
        this.gemeentes = new ArrayList<>();
    }

    public void initializeGemeentes(){
        Gemeente denHaag = new Gemeente("den haag", 514861);
        gemeentes.add(denHaag);

        Azc azc = new Azc("laan van noi",6,"6542 AB");
        denHaag.addAzcs(azc);

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
