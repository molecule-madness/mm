package com.madness.mm;
/* @author Alex Kahn
 * @className Quiz.java
 * @date 10/18/2013
 * @classDescription- This class will serve as the orginator in the memento
 *  pattern and also as the primary driver of the the model
 */
public class Quiz {

	private Quiz state;

    public Quiz(){

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
