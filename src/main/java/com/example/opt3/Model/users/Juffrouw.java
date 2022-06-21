package com.example.opt3.Model.users;

import com.example.opt3.Model.Login;

public class Juffrouw extends Gebruiker {
    public Juffrouw(String name, String straat, String postcode, int huisnummer, double loon, String username, String password) {
        this.adres = new Adres();
        this.omzet = new Omzet();
        this.login = new Login();

        this.name = name;
        this.adres.setStraatnaam(straat);
        this.adres.setPostcode(postcode);
        this.adres.setHuisnummer(huisnummer);
        this.omzet.setLoon(loon);
        this.omzet.setTotaleOmzet(0);
        this.omzet.setTotaleUren(0);
        this.login.setUsername(username);
        this.login.setPassword(password);
    }

}
