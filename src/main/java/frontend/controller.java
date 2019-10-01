/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import Objects.ClassType;
import backend.DataRecollector;
import javax.swing.JTable;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

/**
 *
 * @author eclipse
 */
public class controller {

    private String[] columnNames = {"Nombre de Control", "Estado"};
    public String[][] data = {
        {"Kundan Kumar Jha", "4031", "CSE"},
        {"Anand Jha", "6014", "IT"}
    };
    public ClassType[] tiposEvaluacion;
    private DataRecollector dr;
    ListSelectionListener listen;

    public controller() {
        dr = new DataRecollector();
        tiposEvaluacion = dr.GetDataFromFile();
        
        data = new String[tiposEvaluacion.length][2];
        for (int i = 0; tiposEvaluacion.length > i; i++) {
            data[i][0] = tiposEvaluacion[i].name;
            data[i][1] = ""+tiposEvaluacion[i].setTotalPercent();
        }
    }  
    public void questionTableSetup(JTable table, JLabel title, ClassType info) {
        title.setText(info.name);
        String[][] data;
        String[] columnNames = {"Pregunta", "Que tan cierto"};
        
        int counter = 0;
        data = new String[countElements(info.subtypeQuestionsAnswers)][2];
        
        for(ArrayList<String> as : info.subtypeQuestionsAnswers) {
            for (String s : as) {
                data[counter][0] = s;
                data[counter][1] = "0";
                counter++;
            }
        }

        table.setModel(new javax.swing.table.DefaultTableModel(
                data,
                columnNames
        ));

    }
    
    private int countElements(ArrayList<ArrayList <String>> test){
        int counter=0;
        for(ArrayList<String> as : test){
            for (String s: as){
                counter++;
            }
        }
        return counter;
    }
    
    public void setClassArray(ClassType[] newArray){
        tiposEvaluacion = newArray;
        data = new String[tiposEvaluacion.length][2];
        for (int i = 0; tiposEvaluacion.length > i; i++) {
            data[i][0] = tiposEvaluacion[i].name;
            data[i][1] = ""+tiposEvaluacion[i].setTotalPercent();
        }
    }

}
