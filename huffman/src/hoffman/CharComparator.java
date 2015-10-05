/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoffman;

import java.util.Comparator;

/**
 *
 * @author Pieter
 */

public class CharComparator implements Comparator<Character>
{

    @Override
    public int compare(Character x, Character y)
    {
        if (x < y) return -1;
        if (x > y) return 1;
        return 0;
    }
    
}
