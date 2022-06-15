package com.example.opt3.Model;

public class Babies extends Kinderen {
    String voeding;
    double gewicht;


    public Babies(String naam, String age, String straatnaam, String postcode, String huisnummer,String voeding, String gewicht){
        this.naam = naam;
        this.leeftijd = Integer.parseInt(age);
        this.adres.straatnaam = straatnaam;
        this.adres.postcode = postcode;
        this.adres.huisnummer = Integer.parseInt(huisnummer);
        this.voeding = voeding;
        this.gewicht = Double.parseDouble(gewicht);
    }

    public Babies(String naam, int age, String straatnaam, String postcode, int huisnummer,String voeding, double gewicht){
        this.naam = naam;
        this.leeftijd = age;
        this.adres.straatnaam = straatnaam;
        this.adres.postcode = postcode;
        this.adres.huisnummer = huisnummer;
        this.voeding = voeding;
        this.gewicht = gewicht;
    }


    public String getStraat(){
        return adres.straatnaam;
    }

    public String getPostcode(){
        return adres.postcode;
    }

    public int getHuisNummer(){
        return adres.huisnummer;
    }

    public String getVoeding() {
        return voeding;
    }

    public void setVoeding(String voeding) {
        this.voeding = voeding;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }
}
