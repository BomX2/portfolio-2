package utils;

import model.Land;

import java.util.ArrayList;

public class Landen {
    private ArrayList<Land> landen;

    public Landen() {
        this.landen = new ArrayList<>();
    }

    public void initializeLanden(){
        Land israel = new Land("israel",false);
        landen.add(israel);
    }
    public Land getLand (String naam) {
        for(Land land : landen) {
            if (land.getNaam().equalsIgnoreCase(naam)){
                return land;
            }
        }
        return null;

    }
    public void getAllLanden (){
        for (Land land : landen){
            System.out.printf("naam: %s%n", land.getNaam());
        }
    }
    public void setLanden (Land land){
        landen.add(land);
    }
}
