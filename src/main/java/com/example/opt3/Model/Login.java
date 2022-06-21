package com.example.opt3.Model;

import com.example.opt3.Model.Database;

import java.util.ArrayList;

public class Login {
    private String username;
    private String password;

    Database database = new Database();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



//    public boolean loginCheck(String un, String pw){
//
//        ArrayList<Gastouder> gebruikers = database.reader();
//
//        for (Gastouder gebruiker: gebruikers) {
//            if (un.equals(gebruiker.login.getUsername()) && pw.equals(gebruiker.login.getPassword())){
//
//                return true;
//            }
//            else{
//                return false;
//            }
//        }
//        return false;
//    }

}
