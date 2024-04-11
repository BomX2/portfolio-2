package model;

import utils.*;
import menu.*;

import java.util.Scanner;

public class Main {

    public static void main (String [] args) {

        DataSeeder seeder = DataSeeder.getInstance ();

        while (true) {
            Menu menu = seeder.getMenu ();
            menu.toonMenu();
        }
    }
}