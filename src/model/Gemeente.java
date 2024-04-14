package model;

public class Gemeente {
    private String naam;
    private int inwoners;

    public Gemeente (String naam, int inwoners){
        this.inwoners = inwoners;
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getInwoners() {
        return inwoners;
    }

    public void setInwoners(int inwoners) {
        this.inwoners = inwoners;
    }

}
