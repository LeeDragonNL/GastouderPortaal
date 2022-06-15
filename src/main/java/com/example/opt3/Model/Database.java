package com.example.opt3.Model;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Gebruiker> data = fillarray();


    private static ArrayList<Gebruiker> fillarray(){
        ArrayList<Gebruiker> fill = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Gebruiker gastouder = new Gastouder
                    ("Franklin",
                            "teststraat",
                            "3465AD",
                            Gebruiker.randomInt(),
                            Gebruiker.randomDouble(),
                            Gebruiker.randomDouble(),
                            Gebruiker.randomInt(),
                            "Franklin123",
                            "test");
            fill.add(gastouder);
        }
        return fill;
    }
}
