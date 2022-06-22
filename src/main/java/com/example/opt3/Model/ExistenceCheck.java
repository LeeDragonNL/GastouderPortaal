package com.example.opt3.Model;

import com.example.opt3.Model.users.Gastouder;

import java.util.ArrayList;

public class ExistenceCheck {

    public boolean checkIfExist(String username){
        Database database = new Database();
        ArrayList<Gastouder> gebruikers = database.reader();


        for (Gastouder gebruiker: gebruikers) {
            if (username.equals(gebruiker.getName())){
                return true;
            }
        }
        return false;
    }

    public boolean checkIfTheSame(String str1, String str2){
        if (str1.equals(str2)){
            return true;
        }
        else{
            return false;
        }
    }

}
