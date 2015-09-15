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
    
    public WoordenSorterTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of aantal method, of class WoordenSorter.
     */
    @Test
    public void testAantal()
    {
        System.out.println("aantal");
        String input = "";
        WoordenSorter instance = new WoordenSorter();
        String expResult = "";
        String result = instance.aantal(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sorteer method, of class WoordenSorter.
     */
    @Test
    public void testSorteer()
    {
        System.out.println("sorteer");
        String input = "";
        WoordenSorter instance = new WoordenSorter();
        String expResult = "";
        String result = instance.sorteer(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of frequentie method, of class WoordenSorter.
     */
    @Test
    public void testFrequentie()
    {
        System.out.println("frequentie");
        String input = "";
        WoordenSorter instance = new WoordenSorter();
        String expResult = "";
        String result = instance.frequentie(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of concordatie method, of class WoordenSorter.
     */
    @Test
    public void testConcordatie()
    {
        System.out.println("concordatie");
        String input = "";
        WoordenSorter instance = new WoordenSorter();
        String expResult = "";
        String result = instance.concordatie(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of entriesSortedByValues method, of class WoordenSorter.
     */
    @Test
    public void testEntriesSortedByValues()
    {
        System.out.println("entriesSortedByValues");
        SortedSet<Map.Entry<K, V>> expResult = null;
        SortedSet<Map.Entry<K, V>> result = WoordenSorter.entriesSortedByValues(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
