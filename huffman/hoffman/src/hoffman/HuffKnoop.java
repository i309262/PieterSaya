/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoffman;

/**
 *
 * @author Pieter
 */
public class HuffKnoop
{
    public char karakter;
    public int frequentie;
    public HuffKnoop leftChild, rightChild;
    
    public HuffKnoop(char karakter, int frequentie)
    {
        this.frequentie = frequentie;
        this.karakter = karakter;
    }
}
