/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.util.ArrayList;

/**
 *
 * @author eclipse
 */
public class ClassType {
    public String name;
    public ArrayList<ArrayList<String>> subtypeQuestionsAnswers;
    public ArrayList<String> subtitles;
    public int percentOfValidation;
    public ArrayList<Integer> answers;
    
    public ClassType(String name){
        this.name = name;
        subtypeQuestionsAnswers = new ArrayList<ArrayList<String>>();
        subtitles = new ArrayList<String>();
        answers = new ArrayList<Integer>();

    }
    
    public void addName(String name){
        this.name = name;
    }
    
    public void addQuestion(String question, int index){
        subtypeQuestionsAnswers.get(index).add(question);
        answers.add(0);

    }
    
    public void addSubtitle(String sub){
        subtitles.add(sub);
        subtypeQuestionsAnswers.add(new ArrayList<>());
    }
    
    public int setTotalPercent(){
        int sum = 0;
        int total = answers.size();
        for(int i=0; answers.size() > i; i++){
            sum += answers.get(i);
        }
        percentOfValidation = (int) (sum / total);
        return percentOfValidation;
    }
    
    @Override
    public String toString(){
        String s = "Nombre: " + name + " con los valores:\n";
        for (ArrayList<String> x: subtypeQuestionsAnswers){
            for (String y: x){
                s += y + "\n";
            }
        }
        return s;
    }
}
