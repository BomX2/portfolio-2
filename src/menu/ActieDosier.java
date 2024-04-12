package menu;

import model.Asielzoeker;
import utils.DataSeeder;
import utils.Security;

import java.util.Scanner;

public class ActieDosier implements IActie{
    @Override
    public void voerActieUit() {
        Security security = Security.getInstance();
        Asielzoeker asielzoeker = (Asielzoeker) security.getActieveGebruiker();
        asielzoeker.vraagOp();

    }
}
