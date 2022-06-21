package com.example.opt3.Model;

import java.util.ArrayList;

public class LoginCheck {
    Database database = new Database();
    ArrayList<Gastouder> people = new ArrayList<>();
    public Gastouder gastouders = new Gastouder();

    public LoginCheck(){
        people = database.reader();
    }

    public Gastouder Login(String username, String password){
    for (Gastouder gastouder: people){
        if (gastouder.getLogin().getUsername().equals(username) && gastouder.getLogin().getPassword().equals(password)){
            gastouders = gastouder;
            return gastouders;
        }
    }
    return null;
    }
}
