package com.example.opt3.Model.users;

import com.example.opt3.Model.Login;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class Gebruiker {
        String name;
        Adres adres;
        Omzet omzet;
        Login login;
        ArrayList<Babies> people = new ArrayList<>();

        public Gebruiker(){
            super();
        }


     public Gebruiker(String name, String straat, String postcode, int huisnummer, double loon, String username, String password) {
            this.adres = new Adres();
            this.omzet = new Omzet();
            this.login = new Login();

            this.name = name;
            this.adres.setStraatnaam(straat);
            this.adres.setPostcode(postcode);
            this.adres.setHuisnummer(huisnummer);
            this.omzet.setLoon(loon);
            this.login.setUsername(username);
            this.login.setPassword(password);
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

        public Omzet getOmzet() { return omzet;}

        public void setOmzet(Omzet omzet) { this.omzet = omzet;}

        public Login getLogin() { return login;}

        public void setLogin(Login login) { this.login = login;}

        public ArrayList<Babies> getPeople() { return people;}

        public void setPeople(ArrayList<Babies> people) { this.people = people;}
}
