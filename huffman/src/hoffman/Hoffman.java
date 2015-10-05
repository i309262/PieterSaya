/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoffman;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import sun.awt.HKSCS;

/**
 *
 * @author Pieter
 */
public class Hoffman
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String output = "";
        String aap = "banaan";
        String[] letters = aap.split("");
        
        TreeMap<String, Integer> tm = new TreeMap<>();
        
        for(int i = 0; i < letters.length; i++) //n
        {
            if(tm.containsKey(letters[i])) // n * log n
            {
                tm.put(letters[i], tm.get(letters[i]) + 1); //n * log n
            }
            else
            {
                tm.put(letters[i], 1);
            }
        }
        
        for (Map.Entry<String, Integer> entrySet : entriesSortedByValues(tm))
        {   
            String test1 = entrySet.getKey();
            char test = test1.charAt(0);
            
            HuffKnoop hk = new HuffKnoop( test ,entrySet.getValue());
            
            //output += entrySet.getKey() + ": " + entrySet.getValue() + "\n";
            System.out.println(hk.karakter);
            System.out.println(hk.frequentie);
        }
        //System.out.println(output);
        
        
//        Character[] chars = {'b', 'a', 'n', 'a', 'n', 'e', 'n'};
//        
//        PriorityQueue<Character> PQ = new PriorityQueue<>();
//        for (int i = 0; i < chars.length; i++)
//        {
//            PQ.offer(chars[i]);
//            System.out.println(PQ.toString());
//        }
      
    }
    
    static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) 
    {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(new Comparator<Map.Entry<K,V>>() 
        {
            @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) 
            {
                int res = e1.getValue().compareTo(e2.getValue());
                return res != 0 ? res : 1;
            }
        });
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
    
}

