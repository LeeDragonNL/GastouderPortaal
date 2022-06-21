package com.example.opt3.Model.users;

import com.example.opt3.Model.users.Gebruiker;

public class Gastouder extends Gebruiker {
    public Gastouder() {
        super();
    }

    public Gastouder(String name, String straat, String postcode, int huisnummer, double loon, String username, String password) {
        super(name,straat,postcode,huisnummer,loon,username,password);
    }
}
