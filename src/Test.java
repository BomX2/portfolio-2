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
    @org.junit.jupiter.api.Test
    void plaatsAsiel(){
        Azc azc = new Azc("laan van nooi",4," 6452 DC");
        Azc azc2 = new Azc("laan van nooi",4," 6352 DC");
        GezinsKamer gezinsKamer = new GezinsKamer(1,"","");
        GezinsKamer gezinsKamer1 = new GezinsKamer(0,"","");
        JongerenKamer jongerenKamer = new JongerenKamer(1,"","");
        GewoneKamer gewoneKamer = new GewoneKamer(1,"man","",true);
        azc.addKamers(gewoneKamer);
        azc.addKamers(gezinsKamer);
        azc.addKamers(jongerenKamer);
        azc.addKamers(gezinsKamer1);

        Land land = new Land("TestLand", true);
        Dossier dossier = new Dossier("Gezin1",land, true);

        Asielzoeker asielzoeker = new Asielzoeker("jan","",30,land,dossier);
        asielzoeker.setFamilielid(true);

        Asielzoeker asielzoeker1 = new Asielzoeker("kees","iets anders",30,land,dossier);

        Asielzoeker asielzoeker2 = new Asielzoeker("arno","",25,land,dossier);

        assertTrue(azc.plaatsAsiel(asielzoeker));
        assertFalse(azc.plaatsAsiel(asielzoeker1));
        assertFalse(azc.plaatsAsiel(asielzoeker2));
        assertFalse(azc2.plaatsAsiel(asielzoeker));
    }

    @org.junit.jupiter.api.Test
    void getuitkeringExtra() {
        Beheerder beheerder = new Beheerder("jan");

        Double een = beheerder.getuitkeringExtra(500, 300, 120, 110);
        Double twee = beheerder.getuitkeringExtra(500, 100, 60, 90);
        Double drie = beheerder.getuitkeringExtra(1500, 500, 120, 110);
        Double vier = beheerder.getuitkeringExtra(1500, 800, 60, 90);
        Double vijf = beheerder.getuitkeringExtra(5001, 2000, 120, 110);
        Double zes = beheerder.getuitkeringExtra(5001, 4000, 60, 90);

        assertEquals(4000.0,een);
        assertEquals(500.0,twee);
        assertEquals(3500.0,drie);
        assertEquals(2000.0,vier);
        assertEquals(4000.0,vijf);
        assertEquals(2500.0,zes);

    }
}
