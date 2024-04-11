package utils;

import menu.Menu;

import java.util.ArrayList;

public class DataSeeder {
    private static DataSeeder instance = null;
    ArrayList<Menu> menus;

    private DataSeeder(){
        this.menus = new ArrayList<>();
    }
}
