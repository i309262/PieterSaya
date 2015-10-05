/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoffman;

import java.util.Comparator;
import java.util.PriorityQueue;

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
        Character[] chars = {'b', 'a', 'n', 'a', 'n', 'e', 'n'};
        
        PriorityQueue<Character> PQ = new PriorityQueue<>();
        for (int i = 0; i < chars.length; i++)
        {
            PQ.offer(chars[i]);
            System.out.println(PQ.toString());
        }
      
    }
    
}

