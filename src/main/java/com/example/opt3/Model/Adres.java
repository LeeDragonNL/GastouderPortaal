package com.example.opt3.Model;

public class Adres {
    String straatnaam;
    String postcode;
    int huisnummer;

    public Adres(){

    }
    public Adres(String straatnaam, String postcode, int huisnummer) {
        this.straatnaam = straatnaam;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }
}
