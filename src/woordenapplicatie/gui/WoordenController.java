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
import woordenapplicatie.WoordenSorter;

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

    private woordenapplicatie.WoordenSorter sorter = new WoordenSorter();
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }
    
    @FXML
    private void aantalAction(ActionEvent event) 
    {
        taOutput.setText(sorter.aantal(taInput.getText()));
    }

    @FXML
    private void sorteerAction(ActionEvent event) 
    {
        taOutput.setText(sorter.sorteer(taInput.getText()));
    }

    @FXML
    private void frequentieAction(ActionEvent event) 
    {
        taOutput.setText(sorter.frequentie(taInput.getText()));
    }

    @FXML
    private void concordatieAction(ActionEvent event) 
    {
        taOutput.setText(sorter.concordatie(taInput.getText()));
    }
}