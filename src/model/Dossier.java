package model;

public class Dossier {
    private String naam;
    private Land landVanHerkomst;
    private boolean paspoort;
    private boolean asielaanvraag;
    private String uitspraak;
    private boolean terugkeert;

    public Dossier (String naam, Land landVanHerkomst,boolean paspoort){
        setNaam(naam);
        setLandVanHerkomst(landVanHerkomst);
        setPaspoort(paspoort);
        setAsielaanvraag(false);
        setUitspraak("nee");

    }
    public Dossier (String naam,Land landVanHerkomst, boolean paspoort, boolean asielaanvraag,String uitspraak, boolean terugkeert) {
        setNaam(naam);
        setLandVanHerkomst(landVanHerkomst);
        setPaspoort(paspoort);
        setAsielaanvraag(asielaanvraag);
        setUitspraak(uitspraak);
        setTerugkeert(terugkeert);
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Land getLandVanHerkomst() {
        return landVanHerkomst;
    }

    public void setLandVanHerkomst(Land landVanHerkomst) {
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

    public String getUitspraak() {
        return uitspraak;
    }

    public void setUitspraak(String uitspraak) {
        this.uitspraak = uitspraak;
    }

    public boolean isTerugkeert() {
        return terugkeert;
    }

    public void setTerugkeert(boolean terugkeert) {
        this.terugkeert = terugkeert;
    }
}

