package utils;
import model.*;

public class security {
    private static security instance = null;
    private security () {

    }

    public static security getInstance() {

        if (instance == null){
            instance = new security();
        }
        return instance;
    }

    public boolean isIngelogd (){
        return true;
    }
}
