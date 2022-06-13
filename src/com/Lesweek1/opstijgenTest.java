package com.Lesweek1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class opstijgenTest {

    @Test
    void magOpstijgen() {
        opstijgen opstijgen = new opstijgen(false, 500, 75);
        opstijgen opstijgen1 = new opstijgen(true, 1500, 45);
        opstijgen opstijgen2 = new opstijgen(true, 750, 55);
        opstijgen opstijgen3 = new opstijgen(true, 1100, 57);

        assertFalse(opstijgen.magOpstijgen());
        assertFalse(opstijgen1.magOpstijgen());
        assertTrue(opstijgen2.magOpstijgen());
        assertTrue(opstijgen3.magOpstijgen());
    }
}

class EquivalantieTest {

    @Test
    void prijzen() {

        assertEquals(100, new Vliegtuig(0).prijsberekening());
        assertEquals(100, new Vliegtuig(1).prijsberekening());
        assertEquals(100, new Vliegtuig(999).prijsberekening());
        assertEquals(500, new Vliegtuig(1000).prijsberekening());
        assertEquals(500, new Vliegtuig(1001).prijsberekening());
        assertEquals(500, new Vliegtuig(4999).prijsberekening());
        assertEquals(2500, new Vliegtuig(5000).prijsberekening());
        assertEquals(2500, new Vliegtuig(5001).prijsberekening());
    }
}

class PairWiseTest {

    @Test
    void TotaalBedrag() {

        assertEquals(1089, new Vliegtuig(500, 2, true, true).prijsberekengingFULL());
        assertEquals(150, new Vliegtuig(500, 4, false, false).prijsberekengingFULL());
        assertEquals(605, new Vliegtuig(2500, 2, false, true).prijsberekengingFULL());
        assertEquals(1550, new Vliegtuig(2500, 4, true, false).prijsberekengingFULL());
        assertEquals(3300, new Vliegtuig(7500, 2, true, false).prijsberekengingFULL());
        assertEquals(4537.50, new Vliegtuig(7500, 4, false, true).prijsberekengingFULL());

    }
}