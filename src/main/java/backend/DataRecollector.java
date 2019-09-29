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

    public ArrayList<ArrayList<String>> stringArrayInfo = new ArrayList<ArrayList<String>>();
//    String[] item = fruitList.toArray(new String[fruitList.size()]);  

    public ClassType[] GetDataFromFile() {
//        URL url = DataRecollector.class.getResource("../data/texto_separado.txt").getFile();
        System.out.println("Trying to get file...");

        File file = new File("/home/eclipse/NetBeansProjects/mavenproject1/src/main/java/data/texto_separado.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String tmpString;
            while ((tmpString = br.readLine()) != null) {
                switch (tmpString.charAt(0)){
                        case '#':
                            tmpString = tmpString.substring(1);
                            break;
                        case '^':
                            tmpString = tmpString.substring(1);
                            break;
                        case '$':
                            tmpString = tmpString.substring(1);
                            break;
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataRecollector.class.getName()).log(Level.SEVERE, "HIHIHIHIH", "");
            Logger.getLogger(DataRecollector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataRecollector.class.getName()).log(Level.SEVERE, "HIHIHIHIH", "");
            Logger.getLogger(DataRecollector.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
