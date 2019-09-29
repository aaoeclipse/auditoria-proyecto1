/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author eclipse
 */
public class ClassType {
    public String name;
    public String[][] subtypeQuestionsAnswers;
    public int percentOfValidation;
    public int[] answers;
    
    public ClassType(String name, String[][] subtypeQuestionsAnswers, int[] anwsers){
        this.name = name;
        this.subtypeQuestionsAnswers = subtypeQuestionsAnswers;
        this.percentOfValidation = 0;
        this.answers = anwsers;
    }
    
    public void addName(String name){
        this.name = name;
    }
    
    public void addQuestion(String[][] subtypeQuestionsAnswers){
        this.subtypeQuestionsAnswers = subtypeQuestionsAnswers;

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
        String s = "Nombre: " + name + " con los valores:";
        for (String[] x: subtypeQuestionsAnswers){
            for (String y: x){
                s += y + "\n";
            }
        }
        return s;
    }
}
