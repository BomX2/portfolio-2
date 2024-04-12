package model;

public class Dossier {
    private String naam;
    private String landVanHerkomst;
    private boolean paspoort;
    private boolean asielaanvraag;
    private boolean rechterToeGewezen;
    private boolean uitspraakGedaan;
    private boolean uitspraak;
    private boolean terugkeert;

    public Dossier (String naam, String landVanHerkomst,boolean paspoort){
        setNaam(naam);
        setLandVanHerkomst(landVanHerkomst);
        setPaspoort(paspoort);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public void setLandVanHerkomst(String landVanHerkomst) {
        this.landVanHerkomst = landVanHerkomst;
    }

    public boolean isPaspoort() {
        return paspoort;
    }

    public void setPaspoort(boolean paspoort) {
        this.paspoort = paspoort;
    }

    public boolean isAsielaanvraag() {
        return asielaanvraag;
    }

    public void setAsielaanvraag(boolean asielaanvraag) {
        this.asielaanvraag = asielaanvraag;
    }

    public boolean isRechterToeGewezen() {
        return rechterToeGewezen;
    }

    public void setRechterToeGewezen(boolean rechterToeGewezen) {
        this.rechterToeGewezen = rechterToeGewezen;
    }

    public boolean isUitspraakGedaan() {
        return uitspraakGedaan;
    }

    public void setUitspraakGedaan(boolean uitspraakGedaan) {
        this.uitspraakGedaan = uitspraakGedaan;
    }

    public boolean isUitspraak() {
        return uitspraak;
    }

    public void setUitspraak(boolean uitspraak) {
        this.uitspraak = uitspraak;
    }

    public boolean isTerugkeert() {
        return terugkeert;
    }

    public void setTerugkeert(boolean terugkeert) {
        this.terugkeert = terugkeert;
    }
}
