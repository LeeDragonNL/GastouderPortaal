package com.Lesweek1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class opstijgenTest {

    @Test
    void magOpstijgen() {
        opstijgen opstijgen  = new opstijgen(false,500,75);
        opstijgen opstijgen1 = new opstijgen(true,1500,45);
        opstijgen opstijgen2 = new opstijgen(true,750,55);
        opstijgen opstijgen3 = new opstijgen(true,1100,57);

        assertFalse(opstijgen.magOpstijgen());
        assertFalse(opstijgen1.magOpstijgen());
        assertTrue(opstijgen2.magOpstijgen());
        assertTrue(opstijgen3.magOpstijgen());
    }
}

class prijzentest{

    @Test
    void prijzen(){
//        Vliegtuig vliegtuig  = new Vliegtuig(0);
//        Vliegtuig vliegtuig1 = new Vliegtuig(1);
//        Vliegtuig vliegtuig2 = new Vliegtuig(999);
//        Vliegtuig vliegtuig3 = new Vliegtuig(1000);
//        Vliegtuig vliegtuig4 = new Vliegtuig(1001);
//        Vliegtuig vliegtuig5 = new Vliegtuig(4999);
//        Vliegtuig vliegtuig6 = new Vliegtuig(5000);
//        Vliegtuig vliegtuig7 = new Vliegtuig(5001);

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