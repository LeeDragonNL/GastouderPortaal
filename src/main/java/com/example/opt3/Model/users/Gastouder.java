package com.example.opt3.Model.users;

import com.example.opt3.Model.Invoer;
import java.util.ArrayList;

public class Gastouder extends Gebruiker {
    ArrayList<Invoer> invoers = new ArrayList<>();


    public Gastouder() {
        super();
    }

    public Gastouder(String name, String straat, String postcode, int huisnummer, double loon, String username, String password) {

        super(name,straat,postcode,huisnummer,loon,username,password);
    }

    public ArrayList<Invoer> getInvoers() {
        return invoers;
    }

    public void setInvoers(ArrayList<Invoer> invoers) {
        this.invoers = invoers;
    }
}
