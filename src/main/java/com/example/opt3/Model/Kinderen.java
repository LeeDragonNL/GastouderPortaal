package com.example.opt3.Model;

public abstract class Kinderen {
    String naam;
    int leeftijd;
    Adres adres;

    public Kinderen() {
        this.adres = new Adres();
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
}
