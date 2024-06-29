import model.*;
import utils.DataSeeder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Test {


    @org.junit.jupiter.api.Test
    void voegGemeentetoe(){
        Beheerder beheerder = new Beheerder("jan");

        beheerder.voegGemeentetoe("den haag",1000);

        assertNotNull(DataSeeder.getInstance().getGemeentes().getGemeente("den haag"));
    }

    @org.junit.jupiter.api.Test
    void voegLandToe(){
        Beheerder beheerder = new Beheerder("jan");

        beheerder.voegLandToe("israel",false);

        assertNotNull(DataSeeder.getInstance().getLanden().getLand("israel"));
    }

    @org.junit.jupiter.api.Test
    void isVeilig(){
        Land land = new Land("israel",false);
        Beheerder beheerder = new Beheerder("jan");

        beheerder.isVeilig(land,true);

        assertEquals(true,land.isVeilig());
    }
    @org.junit.jupiter.api.Test
    void registreerVluchteling() {
        CaoMedewerker caoMedewerker = new CaoMedewerker("jan");
        Land land = new Land("israel",true);
        Dossier dossier = new Dossier("jan",land,false);

        Asielzoeker asielzoeker = caoMedewerker.registreerVluchteling(dossier,"man",18);

        assertNotNull(asielzoeker.getDossier());
        assertEquals(dossier.getNaam(),asielzoeker.getNaam());
        assertEquals(dossier.getLandVanHerkomst(),asielzoeker.getLandVanHerkomst());
    }
    @org.junit.jupiter.api.Test
    void getuitkering() {
        Beheerder beheerder = new Beheerder("jan");
        Gemeente gemeente = new Gemeente("den haag",100000);
        int capaciteit = 1;
        int capaciteit1 = 50;
        int capaciteit2 = 99;
        int capaciteit3 = 101;
        int capaciteit4 = 150;
        int capaciteit5 = 300;
        int capaciteit6 = 0;


        int uitkering = beheerder.Getuitkering(gemeente, capaciteit);
        int uitkering1 = beheerder.Getuitkering(gemeente, capaciteit1);
        int uitkering2 = beheerder.Getuitkering(gemeente, capaciteit2);
        int uitkering4 = beheerder.Getuitkering(gemeente, capaciteit3);
        int uitkering5 = beheerder.Getuitkering(gemeente, capaciteit4);
        int uitkering6 = beheerder.Getuitkering(gemeente, capaciteit5);
        int uitkering7 = beheerder.Getuitkering(gemeente, capaciteit6);

        assertEquals(1000,uitkering);
        assertEquals(1000,uitkering1);
        assertEquals(1000,uitkering2);
        assertEquals(2000,uitkering4);
        assertEquals(2000,uitkering5);
        assertEquals(2000,uitkering6);
        assertEquals(0,uitkering7);
    }
}
