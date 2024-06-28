package model;

public abstract class Kamer {
    private int capaciteit;
    private String gender;
    private String bestemming;

    public int getCapaciteit() {
        return capaciteit;
    }

    public String getGender() {
        return gender;
    }
    public void verlaagCapaciteit() {
        if (capaciteit > 0) {
            capaciteit--;
        }
    }
}
