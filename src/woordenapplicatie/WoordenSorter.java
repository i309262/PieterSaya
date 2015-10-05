/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author Pieter
 */
public class WoordenSorter
{
    
    private String[] splitWords(String input)
    {
        return input.split("[\r|\n|\\s|, ]+");
    }
    
    public String aantal(String input) //n * n 
    {
        String output = "";
        String[] woorden = splitWords(input);
        HashSet<String> ketama = new HashSet<>();
        for(int i = 0; i < woorden.length; i++) //n
        {
            ketama.add(woorden[i]); //n
        }
        output += "Aantal woorden: " + woorden.length + "\n";
        output += "Aantal verschillende woorden: " + ketama.size();
        return output;
    }
    
    public String sorteer(String input) // n* log n
    {
        String output = "";
        String[] woorden = splitWords(input);
        TreeSet<String> treeSetWords = new TreeSet<>(Collections.reverseOrder());
        
        for(int i = 0; i < woorden.length; i++) // n
        {
            treeSetWords.add(woorden[i]); // log n
        }
        while(treeSetWords.size() > 0)
        {
            output += treeSetWords.pollFirst() + "\n";
        }
        return output;
    }
    
    public String frequentie(String input)
    {
        String output = "";
        String[] woorden = splitWords(input);
        TreeMap<String, Integer> tm = new TreeMap<>();
        
        for(int i = 0; i < woorden.length; i++) //n
        {
            if(tm.containsKey(woorden[i])) // n * log n
            {
                tm.put(woorden[i], tm.get(woorden[i]) + 1); //n * log n
            }
            else
            {
                tm.put(woorden[i], 1);
            }
        }
        
        for (Map.Entry<String, Integer> entrySet : entriesSortedByValues(tm))
        {
            output += entrySet.getKey() + ": " + entrySet.getValue() + "\n";
        }
        return output;
    }
    
    public String concordatie(String input)
    {
        TreeMap<String, String> hm = new TreeMap<>();
        //  TreeMap<String, ArrayList<Integer> hm = new TreeMap<>();
        
        String output = "";
        String[] lines = input.split("\n");
        
        for (int i = 0; i < lines.length; i++)
        {
            String[] words = splitWords(lines[i]);
            for (int j = 0; j < words.length; j++) //n
            {
                if(!words[j].isEmpty())
                {
                    if(hm.containsKey(words[j])) //n * log n
                    {
                        String[] values = hm.get(words[j]).split(",");
                        boolean found = false;
                        for (String value : values)
                        {
                            if(value.equals(String.valueOf(i + 1)))
                            {
                                found = true;
                            }
                        }
                        if(!found)
                        {
                            hm.put(words[j], hm.get(words[j]) + "," + (i + 1)); // n *log n
                        }
                    }
                    else
                    {
                        hm.put(words[j], "" + (i + 1));
                    }
                }
            }
            
        }
        
        for (HashMap.Entry<String, String> entrySet : hm.entrySet())
        {
            output += entrySet.getKey() + ": [" + entrySet.getValue() + "]\n";
        }
        return output;
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
