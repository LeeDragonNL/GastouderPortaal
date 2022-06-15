package com.example.opt3.Model;

public class Gastouder extends Gebruiker {

    public Gastouder(String name, String straat, String postcode, int huisnummer, double loon, double totaleomzet, int uren, String username, String password) {
        this.adres = new Adres();
        this.omzet = new Omzet();
        this.login = new Login();
        this.name = name;
        this.adres.setStraatnaam(straat);
        this.adres.setPostcode(postcode);
        this.adres.setHuisnummer(huisnummer);
        this.omzet.setLoon(loon);
        this.omzet.setTotaleOmzet(totaleomzet);
        this.omzet.setTotaleUren(uren);
        this.login.setUsername(username);
        this.login.setPassword(password);
    }
    @Override
    void profielAanmaken() {


    }
}
