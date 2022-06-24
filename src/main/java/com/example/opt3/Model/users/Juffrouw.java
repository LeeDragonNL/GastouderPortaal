package com.example.opt3.Model.users;

import com.example.opt3.Model.Invoer;
import com.example.opt3.Model.Login;

import java.util.ArrayList;

public class Juffrouw extends Gebruiker {
    ArrayList<Invoer> invoers = new ArrayList<>();


    public Juffrouw() {
        super();
    }

    public Juffrouw(String name, String straat, String postcode, int huisnummer, double loon, String username, String password) {

        super(name,straat,postcode,huisnummer,loon,username,password);
    }

    public ArrayList<Invoer> getInvoers() {
        return invoers;
    }

    public void setInvoers(ArrayList<Invoer> invoers) {
        this.invoers = invoers;
    }

}
