/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import Objects.ClassType;
import backend.DataRecollector;
import frontend.*;

/**
 *
 * @author eclipse
 */
public class NewClass {
    public ClassType[] testType;
    public DataRecollector dr;
    
    public NewClass(){
        dr = new DataRecollector();
        testType = dr.GetDataFromFile();
        
    }
    
    public void PrintInfo(){
        for (ClassType s : testType){
              System.out.println(s);
          }
    }
    public static void main(String[] args){
        controller control = new controller();
        mainsrc gui = new mainsrc(control);
//          BarChar bargraph = new BarChar();
        
        
    }
    
}
