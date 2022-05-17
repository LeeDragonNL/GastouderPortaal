package com.Lesweek1;

public class Vliegtuig {

    private int gewicht;
    private int passagier;
    private boolean bagageAfhandeling;
    private boolean isNederlandsVliegtuig;

    public Vliegtuig(int gewicht) {
        this.gewicht = gewicht;
    }

    public Vliegtuig(int gewicht, int passagier, boolean bagageAfhandeling, boolean isNederlandsVliegtuig) {
        this.gewicht = gewicht;
        this.passagier = passagier;
        this.bagageAfhandeling = bagageAfhandeling;
        this.isNederlandsVliegtuig = isNederlandsVliegtuig;
    }

    //methode neemt de berekeningen van de menthode passagiergewicht() en bagageAfhandeling()
    //die worden bij elkaar opgeteld en vervolgens wordt er gekeken of het vliegtuig nederlands is
    //zo ja wordt er 21% btw erbij berekend en dan gereturned.
    //zo nee wordt het totaalbedrag zonder btw gereturned.
    public double prijsberekengingFULL(){
        int TotaalBedrag = passagierGewicht() + bagageAfhandeling();

        if (isNederlandsVliegtuig){
            return TotaalBedrag * 1.21;
        }
        else {
            return TotaalBedrag;
        }
    }

    public int passagierGewicht(){
        if (passagier <= 2){
            if (gewicht < 1000){
                return 100;
            }
            else if(gewicht < 5000){
                return 500;
            }
            else {
                return 2500;
            }
        }

        else{
            if (gewicht < 1000){
                return 150;
            }
            else if(gewicht < 5000){
                return 750;
            }
            else {
                return 3750;
            }
        }
    }

    public int bagageAfhandeling(){
        if (bagageAfhandeling){
            return 800;
        }
        else{
            return 0;
        }
    }
//Berekening voor de Equivalentieklassen
    public int prijsberekening(){
        if (gewicht < 1000){
            return 100;
        }
        else if(gewicht < 5000){
            return 500;
        }
        else {
            return 2500;
        }
    }
}
