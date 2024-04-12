package model;

public class Dossier {
    private String naam;
    private String landVanHerkomst;
    private boolean paspoort;
    private boolean asielaanvraag;
    private boolean rechterToeGewezen;
    private String uitspraakGedaan;
    private String uitspraak;
    private boolean terugkeert;

    public Dossier (String naam, String landVanHerkomst,boolean paspoort){
        setNaam(naam);
        setLandVanHerkomst(landVanHerkomst);
        setPaspoort(paspoort);
        setAsielaanvraag(false);
        setRechterToeGewezen(false);
        setUitspraakGedaan("nee");
        setUitspraak("nee");

    }
    public Dossier (String naam,String landVanHerkomst, boolean paspoort, boolean asielaanvraag, boolean rechterToeGewezen,String uitspraakGedaan, String uitspraak, boolean terugkeert) {
        setNaam(naam);
        setLandVanHerkomst(landVanHerkomst);
        setPaspoort(paspoort);
        setAsielaanvraag(asielaanvraag);
        setRechterToeGewezen(rechterToeGewezen);
        setUitspraakGedaan(uitspraakGedaan);
        setUitspraak(uitspraak);
        setTerugkeert(terugkeert);
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
    public String getUitspraak() {
        return uitspraak;
    }

    public void setUitspraak(String uitspraak) {
        this.uitspraak = uitspraak;
    }


    public String getUitspraakGedaan() {
        return uitspraakGedaan;
    }

    public void setUitspraakGedaan(String uitspraakGedaan) {
        this.uitspraakGedaan = uitspraakGedaan;
    }

    public boolean isTerugkeert() {
        return terugkeert;
    }

    public void setTerugkeert(boolean terugkeert) {
        this.terugkeert = terugkeert;
    }
}

