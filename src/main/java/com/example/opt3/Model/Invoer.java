package com.example.opt3.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class Invoer {
    private int uur;
    private int aantalKinderen;
    private String datum;

    public Invoer(){
        super();
    }

    public Invoer(int uur, int aantalKinderen) {
        LocalDate localTime = LocalDate.now();
        this.uur = uur;
        this.aantalKinderen = aantalKinderen;

        this.datum = localTime.toString();
    }


    public int getUur() {
        return uur;
    }

    public void setUur(int uur) {
        this.uur = uur;
    }

    public int getAantalKinderen() {
        return aantalKinderen;
    }

    public void setAantalKinderen(int aantalKinderen) {
        this.aantalKinderen = aantalKinderen;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}
