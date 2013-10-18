package com.madness.mm;

/**
 * @author Alex Kahn
 * @className Memento.java
 * @date 10/18/2013
 * @classDescription- this is where the data for the quiz is saved
 *
 */
public class Memento {

    private Quiz state;

    public Memento(Quiz quiz){
        //TODO things go here
    }
    public Quiz get_State(){
        return state;
    }

    public void set_State(Quiz quiz){
        state = quiz;
    }

}
