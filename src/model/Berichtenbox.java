package model;

import java.util.ArrayList;

public class Berichtenbox{
    ArrayList<Bericht> berichten;

    public Berichtenbox (){
        berichten = new ArrayList<>();
    }

    public void voegBericht (Bericht bericht) {
        berichten.add(bericht);
    }

}
