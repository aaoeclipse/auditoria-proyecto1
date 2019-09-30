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
    public int[] answers;
    
    public ClassType(String name){
        this.name = name;
        subtypeQuestionsAnswers = new ArrayList<ArrayList<String>>();
        subtitles = new ArrayList<String>();
    }
    
    public void addName(String name){
        this.name = name;
    }
    
    public void addQuestion(String question, int index){
        subtypeQuestionsAnswers.get(index).add(question);
    }
    
    public void addQuestions(ArrayList<ArrayList<String>> subtypeQuestionsAnswers){
        this.subtypeQuestionsAnswers = subtypeQuestionsAnswers;

    }
    
    public void addSubtitle(String sub){
        subtitles.add(sub);
        subtypeQuestionsAnswers.add(new ArrayList<>());
    }
    
    public int setTotalPercent(){
        int sum = 0;
        int total = answers.length;
        for(int i=0; answers.length >= i; i++){
            //TODO: we need to make this work
            sum += answers[i];
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
