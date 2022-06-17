package com.example.opt3.Model;

import java.util.ArrayList;

public class Creator {
    Database database = new Database();

    public void createGastouder(String name, String straat, String postcode, int huisnummer, double loon, String username, String password){
        Gastouder gastouder = new Gastouder(name,straat,postcode,huisnummer,loon,username,password);
        ArrayList<Gebruiker> gebruikers = database.reader2("Gebruikers.json");
        gebruikers.add(gastouder);
        database.writer2(gebruikers, "Gebruiker.json");

    }
    public void createJuffrouw(String name, String straat, String postcode, int huisnummer, double loon, String username, String password){
        Juffrouw  juffrouw = new Juffrouw(name,straat,postcode,huisnummer,loon,username,password);
        ArrayList<Gebruiker> gebruikers = database.reader2("Gebruikers.json");
        gebruikers.add(juffrouw);
        database.writer2(gebruikers, "Gebruiker.json");
    }

    public void createbaby(String naam, String age, String straatnaam, String postcode, String huisnummer,String voeding, String gewicht){
        Babies babies = new Babies(naam, age , straatnaam, postcode, huisnummer, voeding, gewicht);
        ArrayList<Babies>
    }
}
