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

        Asielzoeker asielzoeker = caoMedewerker.registreerVluchteling(dossier);

        assertNotNull(asielzoeker.getDossier());
        assertEquals(dossier.getNaam(),asielzoeker.getNaam());
        assertEquals(dossier.getLandVanHerkomst(),asielzoeker.getLandVanHerkomst());
    }
}