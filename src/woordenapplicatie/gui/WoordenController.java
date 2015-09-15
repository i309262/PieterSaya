package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }
    
    private String[] splitWords(String input)
    {
        return input.split("[\r|\n|\\s|, ]+");
    }
    
    
    
    @FXML
    private void aantalAction(ActionEvent event) 
    {
        String output = "";
        String[] woorden = splitWords(taInput.getText());
        HashSet<String> ketama = new HashSet<>();
        for(int i = 0; i < woorden.length; i++)
        {
            ketama.add(woorden[i]);
        }
        output += "Aantal woorden: " + woorden.length + "\n";
        output += "Aantal verschillende woorden: " + ketama.size() + "\n";
        taOutput.setText(output);
    }

    @FXML
    private void sorteerAction(ActionEvent event) 
    {
        String output = "";
        String[] woorden = splitWords(taInput.getText());
        TreeSet<String> treeSetWords = new TreeSet<>(Collections.reverseOrder());
        
        for(int i = 0; i < woorden.length; i++)
        {
            treeSetWords.add(woorden[i]);
        }
        while(treeSetWords.size() > 0)
        {
            output += treeSetWords.pollFirst() + "\n";
        }
        taOutput.setText(output);
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
    
    @FXML
    private void frequentieAction(ActionEvent event) 
    {
        String output = "";
        String[] woorden = splitWords(taInput.getText());
        TreeMap<String, Integer> tm = new TreeMap<>();
        
        for(int i = 0; i < woorden.length; i++)
        {
            if(tm.containsKey(woorden[i]))
            {
                tm.put(woorden[i], tm.get(woorden[i]) + 1);
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
        taOutput.setText(output);
    }

    @FXML
    private void concordatieAction(ActionEvent event) 
    {
        TreeMap<String, String> hm = new TreeMap<>();
        
        String output = "";
        String[] lines = taInput.getText().split("\n");
        
        for (int i = 0; i < lines.length; i++)
        {
            String[] words = splitWords(lines[i]);
            for (int j = 0; j < words.length; j++)
            {
                if(!words[j].isEmpty())
                {
                    if(hm.containsKey(words[j]))
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
                            hm.put(words[j], hm.get(words[j]) + "," + (i + 1));
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
        taOutput.setText(output);
        
        
        
    }
   
}