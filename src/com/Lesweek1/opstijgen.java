package com.Lesweek1;

public class opstijgen {
    private boolean toestemming;
    private int gewicht;
    private int tegenwind;

    public opstijgen(boolean toestemming, int gewicht, int tegenwind) {
        this.toestemming = toestemming;
        this.gewicht = gewicht;
        this.tegenwind = tegenwind;
    }

    public boolean magOpstijgen(){
        return toestemming && (gewicht < 1000 || tegenwind > 50);
    }

}
