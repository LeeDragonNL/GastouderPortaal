package com.example.opt3.Model;

import java.util.ArrayList;

    public abstract class Gebruiker {
        String name;
        Adres adres;
        Omzet omzet;
        ArrayList<Kinderen> kinderen = new ArrayList<>();

        public Gebruiker() {
            this.adres = new Adres();
            this.omzet = new Omzet();

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Adres getAdres() {
            return adres;
        }

        public void setAdres(Adres adres) {
            this.adres = adres;
        }

        abstract void profielAanmaken();
    }
