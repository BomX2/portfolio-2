package model;

public class land {
    private String naam;
    private boolean veilig;

    public land (String naam,boolean veilig){
        this.naam = naam;
        this.veilig = veilig;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isVeilig() {
        return veilig;
    }

    public void setVeilig(boolean veilig) {
        this.veilig = veilig;
    }
}
