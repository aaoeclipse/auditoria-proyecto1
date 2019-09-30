/*
 * Esta clase solo llama al texto separado para guardar la informacion 
 */
package backend;

import Objects.ClassType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eclipse
 */
public class DataRecollector {

    private ArrayList<ArrayList<String>> stringArrayInfo = new ArrayList<ArrayList<String>>();
    private ArrayList<String> subTitulos =  new ArrayList<String>();
    private ArrayList<String> Titulos =  new ArrayList<String>();

//    String[] item = fruitList.toArray(new String[fruitList.size()]);  

    public ClassType[] GetDataFromFile() {
//        URL url = DataRecollector.c   lass.getResource("../data/texto_separado.txt").getFile();
        System.out.println("Trying to get file...");
        ClassType[] item = null;

        File file = new File("/home/eclipse/NetBeansProjects/mavenproject1/src/main/java/data/texto_separado.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String tmpString;
            ArrayList<ClassType>  tmpClassType= new ArrayList<ClassType>();
            ClassType temp;
            int counter = 0;
            int counterSub = 0;
            

            while ((tmpString = br.readLine()) != null) {
                
                switch (tmpString.charAt(0)){
                        case '#':
                            tmpString = tmpString.substring(1);
                            temp = new ClassType(tmpString);
                            tmpClassType.add(temp);
                            counter++;
                            counterSub = 0;
                            break;
                        case '^':
                            tmpString = tmpString.substring(1);
                            tmpClassType.get(counter-1).addSubtitle(tmpString);
                            counterSub++;
                  
                            break;
                        case '$':
                            tmpString = tmpString.substring(1);
                            tmpClassType.get(counter-1).addQuestion(tmpString, counterSub-1);
                            break;
                }            
            }
            
            item = tmpClassType.toArray(new ClassType[tmpClassType.size()]); 

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataRecollector.class.getName()).log(Level.SEVERE, "HIHIHIHIH", "");
            Logger.getLogger(DataRecollector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataRecollector.class.getName()).log(Level.SEVERE, "HIHIHIHIH", "");
            Logger.getLogger(DataRecollector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return item;
    }

}
