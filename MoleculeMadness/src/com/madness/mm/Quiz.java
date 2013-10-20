package com.madness.mm;

import java.util.ArrayList;

/* @author Alex Kahn
 * @className Quiz.java
 * @date 10/18/2013
 * @classDescription- This class will serve as the orginator in the memento
 *  pattern and also as the primary driver of the the model
 */
public class Quiz {

	private Quiz state;
    boolean difficulty;
    boolean type;
    ArrayList<Question> questions;


    /* if difficulty is true its easy else its hard
     * if type is true its scoring else its time attack
     */
    public Quiz(boolean difficulty, boolean type){
        this.type = type;
        this.difficulty = difficulty;
        questions = new ArrayList<Question>();
	}

    public ArrayList<Question> getQuestions() {
        return questions;
    }

	public Memento create_Memento(){
	    System.out.println("Creating the memento");
        return new Memento(state);
    }

    public void set_Memento(Quiz quiz){
        System.out.println("Setting the memento");
        state = quiz;
    }

    public void restore_From_Memento(Memento m){
        state = m.get_State();
        System.out.println("restoring the state");
    }
}
