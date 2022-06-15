package com.example.opt3.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import static io.github.palexdev.materialfx.utils.RandomUtils.random;

public abstract class Gebruiker {
        private String name;
        private Adres adres;
        private Omzet omzet;
        private Login login;
        public static final ObservableList<Babies> people;
        static {
            people = FXCollections.observableArrayList(
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble()),
                    new Babies("welkom", randomInt(), "eggef","egrge",randomInt(),"ergerg",randomDouble())
            );
        }

        public Gebruiker() {
//            this.adres = new Adres();
//            this.omzet = new Omzet();

        }


        public static int randomInt(){
            int max = 5;
            int min = 0;
            return random.nextInt(max - min + 1) + min;
        }

        public static double randomDouble(){
        double max = 10.0;
        double min = 0;
        return random.nextDouble(max - min + 1) + min;
    }

    public boolean loginCheck(String un, String pw){
        return un.equals(login.getUsername()) && pw.equals(login.getPassword());
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
