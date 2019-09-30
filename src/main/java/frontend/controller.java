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
    private String[][] data = {
        {"Kundan Kumar Jha", "4031", "CSE"},
        {"Anand Jha", "6014", "IT"}
    };
    private ClassType[] tiposEvaluacion;
    private DataRecollector dr;
    ListSelectionListener listen;

    public controller() {
        dr = new DataRecollector();
        tiposEvaluacion = dr.GetDataFromFile();
        data = new String[tiposEvaluacion.length][2];
        for (int i = 0; tiposEvaluacion.length > i; i++) {
            data[i][0] = tiposEvaluacion[i].name;
            data[i][1] = "0%";
        }
    }

    public void addRowsSetUp(JTable table) {
//        table = new JTable(data, columnNames); 
        table.setModel(new javax.swing.table.DefaultTableModel(
                data,
                columnNames
        ));
        ListSelectionModel model = table.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!model.isSelectionEmpty()) {
                    // Get selected row
                    int selectedRow = model.getMinSelectionIndex();
                    Questions guiQuestion = new Questions(tiposEvaluacion[selectedRow]);
                }
            }
        });
    }

    public void questionTableSetup(JTable table, JLabel title, ClassType info) {
        title.setText(info.name);
        String[][] data;
        String[] columnNames = {"Pregunta", "Que tan cierto"};
        System.out.println("test test: "+ info.subtypeQuestionsAnswers.size());
        data = new String[info.subtypeQuestionsAnswers.size()][2];
        int counter = 0;

        for (int i = 0; info.subtypeQuestionsAnswers.size() > i; i++) {
            for (String s : info.subtypeQuestionsAnswers.get(i)) {
                data[i][0] = s;
                data[i][1] = "0%";
                counter++;

            }
        }

        table.setModel(new javax.swing.table.DefaultTableModel(
                data,
                columnNames
        ));

    }

}
