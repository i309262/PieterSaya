/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Map;
import java.util.SortedSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Saya
 */
public class WoordenSorterTest
{
    WoordenSorter ws;
    
    public WoordenSorterTest()
    {
        ws = new WoordenSorter();
    }
    
    @Before
    public void setUp()
    {
        //WoordenSorter ws = new WoordenSorter();
    }

    /**
     * Test of aantal method, of class WoordenSorter.
     */
    @Test
    public void testAantal()
    {
        //WoordenSorter ws = new WoordenSorter();
        String expResult1 = "Aantal woorden: 2\n" +
                            "Aantal verschillende woorden: 2";
        String result1 = ws.aantal("Harry Potter");
        assertEquals("zijn niet gelijk", expResult1, result1);

        
        String expResult2 = "Aantal woorden: 5\n" +
                            "Aantal verschillende woorden: 2";
        String result2 = ws.aantal("Harry Potter Potter Potter Potter");
        assertEquals("zijn niet gelijk", expResult2, result2);
        
        String expResult3 = "Aantal woorden: 0\n" +
                            "Aantal verschillende woorden: 0";
        String result3 = ws.aantal(" ");
        assertEquals("zijn niet gelijk", expResult3, result3);
        
    }

    /**
     * Test of sorteer method, of class WoordenSorter.
     */
    @Test
    public void testSorteer()
    {
        String expResult1 = "Potter\n"
                            + "Harry\n";

        String result1 = ws.sorteer("Harry Potter");
        assertEquals("zijn niet gelijk", expResult1, result1);
        
        String expResult2 = "Ron\n" +
                            "Potter\n" +
                            "Mumbledore\n" +
                            "Hermelien\n" +
                            "Harry\n" +
                            "Hagrid\n";
        String result2 = ws.sorteer("Harry Potter, Hermelien, Ron   Hagrid Potter Mumbledore ");
        assertEquals("zijn niet gelijk", expResult2, result2);
        
        String expResult3 = "";
        String result3 = ws.sorteer(" ");
        assertEquals("zijn niet gelijk", expResult3, result3);
    }

    /**
     * Test of frequentie method, of class WoordenSorter.
     */
    @Test
    public void testFrequentie()
    {
        String expResult1 = "Harry: 1\n" +
                            "Potter: 1\n";

        String result1 = ws.frequentie("Harry Potter");
        assertEquals("zijn niet gelijk", expResult1, result1);
        
        String expResult2 = "Cumbledore: 1\n" +
                            "Hagrid: 1\n" +
                            "Harry: 1\n" +
                            "Hermelien: 1\n" +
                            "Ron: 1\n" +
                            "Potter: 2\n";
        String result2 = ws.frequentie("Harry Potter, Hermelien, Ron   Hagrid Potter Cumbledore ");
        assertEquals("zijn niet gelijk", expResult2, result2);
        
        String expResult3 = "";
        String result3 = ws.frequentie(" ");
        assertEquals("zijn niet gelijk", expResult3, result3);
    }

    /**
     * Test of concordatie method, of class WoordenSorter.
     */
    @Test
    public void testConcordatie()
    {
        String expResult1 = "Harry: [1]\n" +
                            "Potter: [1]\n";

        String result1 = ws.concordatie("Harry Potter");
        assertEquals("zijn niet gelijk", expResult1, result1);
        
        String expResult2 = "Hagrid: [3]\n" +
                            "Harry: [1]\n" +
                            "Hermelien: [2]\n" +
                            "Potter: [1,3]\n" +
                            "Ron: [2]\n" +
                            "Stumbledore: [4]\n";
        String result2 = ws.concordatie("Harry Potter,\n Hermelien, Ron\n   Potter Hagrid Potter\n Stumbledore ");
        assertEquals("zijn niet gelijk", expResult2, result2);
        
        String expResult3 = "";
        String result3 = ws.concordatie(" ");
        assertEquals("zijn niet gelijk", expResult3, result3);
    }
    
}
