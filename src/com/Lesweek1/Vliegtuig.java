package com.Lesweek1;

public class Vliegtuig {

    private int gewicht;

    public Vliegtuig(int gewicht) {
        this.gewicht = gewicht;
    }



    public int prijsberekening(){
        if (gewicht < 1000){
            return 100;
        }
        else if(gewicht  >= 1000 && gewicht < 5000){
            return 500;
        }
        else {
            return 2500;
        }
    }
}
