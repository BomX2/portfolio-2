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
    public ArrayList<Bericht> getBerichten() {
        return berichten;
    }
    public void printBericht (int num){
        Bericht bericht = berichten.get(num);

        System.out.println(bericht.getOnderwerp());
        System.out.println(bericht.getNaam());
        System.out.println(bericht.getInfo());
    }
}
