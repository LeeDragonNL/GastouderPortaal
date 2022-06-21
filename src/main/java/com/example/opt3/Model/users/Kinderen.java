package com.example.opt3.Model.users;

public abstract class Kinderen {
    String naam;
    int leeftijd;
    Adres adres;

    public Kinderen(){
        super();
    }

    public Kinderen(String naam,int leeftijd, String Straat, String Postcode, int HuisNummer){
        this.adres = new Adres();
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres.setStraatnaam(Straat);
        this.adres.setPostcode(Postcode);
        this.adres.setHuisnummer(HuisNummer);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
