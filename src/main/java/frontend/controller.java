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
import javax.swing.table.TableColumn;

/**
 *
 * @author eclipse
 */
public class controller {
    private String[] columnNames = {"hello world", "another test"};
    private String[][] data = { 
            { "Kundan Kumar Jha", "4031", "CSE" }, 
            { "Anand Jha", "6014", "IT" } 
        }; 
    private ClassType[] tiposEvaluacion;
    private DataRecollector dr;
    
    public controller(){
        tiposEvaluacion = dr.GetDataFromFile();
    }
    
    public void addRowsSetUp(JTable table){
        System.out.println(table.getColumnName(0));
//        table = new JTable(data, columnNames); 
         table.setModel(new javax.swing.table.DefaultTableModel(
            data,
            columnNames
        ));
        System.out.println(table.getColumnName(0));
    }
    
    public void questionTableSetup(JTable table){
        
    }
    
}
